package com.example.demo.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
public class TestController {


    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/test")
    public ResponseEntity test() {
        this.rabbitTemplate.convertAndSend("test.krw.buy", "hello");
        return ResponseEntity.ok().body(null);
    }

}
