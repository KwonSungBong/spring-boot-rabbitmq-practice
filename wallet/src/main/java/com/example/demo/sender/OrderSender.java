package com.example.demo.sender;

import com.example.demo.vo.Order;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderSender {

    @Autowired
    private RabbitTemplate rabbitTemplate ;

    public void order(String currency, String baseCurrency, Order vo) {
    	StringBuffer exchangeName = new StringBuffer(currency.toLowerCase());
		exchangeName.append("."+baseCurrency.toLowerCase());
    	exchangeName.append(".res-order-exchange");
    	
    	StringBuffer routingKey = new StringBuffer(currency.toLowerCase());
    	routingKey.append("."+baseCurrency.toLowerCase());
        rabbitTemplate.convertAndSend(exchangeName.toString(), routingKey.toString(), vo);
    }
}
