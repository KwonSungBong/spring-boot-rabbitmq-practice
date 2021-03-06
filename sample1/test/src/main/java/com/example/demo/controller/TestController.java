package com.example.demo.controller;

import com.example.demo.listener.TestListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/status")
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Value("${rmq.routingkey}")
    private String ROUTING_KEY;

    @Value("${rmq.order.queue.buy}")
    private String ORDER_BUY_QUEUE;

    @Value("${rmq.order.queue.sell}")
    private String ORDER_SELL_QUEUE;

    @Value("${rmq.order.exchange.buy}")
    private String ORDER_BUY_EXCHANGE;

    @Value("${rmq.order.exchange.sell}")
    private String ORDER_SELL_EXCHANGE;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/test")
    public ResponseEntity test() {
        this.rabbitTemplate.convertAndSend(ORDER_BUY_QUEUE, "hello");
        return ResponseEntity.ok().body(null);
    }

    @GetMapping("/testtest")
    public ResponseEntity testtest() {
        rabbitTemplate.convertAndSend(TestListener.QUEUE_NAME, null, "TESTTEST");
        return ResponseEntity.ok().body(null);
    }

    @GetMapping("/testtesttest")
    public ResponseEntity testtesttest() {
        rabbitTemplate.convertAndSend("test.btc.cancel-exchange", "test.btc", "test");
        return ResponseEntity.ok().body(null);
    }

//    @GetMapping("/testtesttesttest")
//    public ResponseEntity testtesttesttest() {
//        rabbitTemplate.convertAndSend("test.btc.cancel", null, "testtest");
//        return ResponseEntity.ok().body(null);
//    }

}
