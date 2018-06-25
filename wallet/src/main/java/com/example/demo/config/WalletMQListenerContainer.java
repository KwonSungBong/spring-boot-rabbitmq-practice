package com.example.demo.config;

import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;

import java.io.IOException;

public class WalletMQListenerContainer extends SimpleMessageListenerContainer {

    private static final Logger logger = LoggerFactory.getLogger(WalletMQListenerContainer.class);

    public void addQueue(String routingKey, String queueCurrency, String modNumber) {
        Channel channel = this.getConnectionFactory().createConnection().createChannel(false);

        String exchangeNameForm = null;
        String queueNameForm = null;

        // modNumber 가 없으면 리턴
        if (modNumber == null) {
            return;
        }
        String[] arrQueueName = modNumber.split(",");
        if (arrQueueName != null && arrQueueName.length > 0) {
            for (int userModIdx = 0; userModIdx < arrQueueName.length; userModIdx++) {
                exchangeNameForm = String.format("%s.%s-exchange%s", routingKey, queueCurrency, arrQueueName[userModIdx]);
                queueNameForm = String.format("%s.%s%s", routingKey, queueCurrency, arrQueueName[userModIdx]);

                try {
                    channel.queueDeclare(queueNameForm, true, false, false, null);
                    channel.exchangeDeclare(exchangeNameForm, "topic", true);
                    channel.queueBind(queueNameForm, exchangeNameForm, routingKey);
                } catch (IOException ex) {
                    // 큐생성 및 바인딩 실패로그
                    continue;
                }
                this.addQueueNames(queueNameForm);
            }
        } else {
            // listener list empty
        }
    }

    public void addQueues(String routingKey, String[] queueCurrencies, String modNumber) throws Exception {
        if(queueCurrencies == null) {
            throw new RuntimeException("신규 RabbitMQ 생성에 필요한 암호화폐 정책이 없습니다.");
        }
        int nCrncyCnt = queueCurrencies.length;
        for(int i=0; i<nCrncyCnt; i++) {
            this.addQueue(routingKey, queueCurrencies[i], modNumber);
        }
    }
}
