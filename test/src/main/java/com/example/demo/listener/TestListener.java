package com.example.demo.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class TestListener {

    public final static String QUEUE_NAME = "test.test.queue";

    private ObjectMapper objectMapper = new ObjectMapper();

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(autoDelete = "true"),
            exchange = @Exchange(value = QUEUE_NAME, type= ExchangeTypes.TOPIC, autoDelete = "true"))
    )
    public void receiveEvent(Message message) throws IOException {
        System.out.println("TSETTEST : "+message);
    }

    @RabbitListener(id = "test.eth.btc", bindings = @QueueBinding(
            value = @Queue(value = "test.btc.cancel", durable = "true"),
            exchange = @Exchange(value = "test.btc.cancel-exchange", type = "topic", durable = "true"),
            key = "test.btc"))
    public void receiveMessage(Message message) {
        System.out.println("TSETTEST : "+message);
    }

}
