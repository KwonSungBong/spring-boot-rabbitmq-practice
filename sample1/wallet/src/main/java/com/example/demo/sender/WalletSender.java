package com.example.demo.sender;

import com.example.demo.config.RabbitMQConfig;
import com.example.demo.vo.Order;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WalletSender {

    @Autowired
    private RabbitTemplate rabbitTemplate ;

    public void withdrawRes(Order vo) {
    		String exchangeName = "wallet.res-withdraw-exchange";
    		rabbitTemplate.convertAndSend(exchangeName, RabbitMQConfig.ROUTING_KEY, vo);
    }
}
