package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/status")
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private ApplicationContext ctxt;

    @GetMapping("/check")
    public ResponseEntity checkState() {
        logger.debug("Check Listener State.............................");
        Map res = new HashMap();
        boolean buySts = ctxt.getBean("buyContainer", SimpleMessageListenerContainer.class).isRunning();
        boolean sellSts = ctxt.getBean("sellContainer", SimpleMessageListenerContainer.class).isRunning();
        res.put("Order.Buy", buySts);
        res.put("Order.Sell", sellSts);
        return ResponseEntity.ok().body(res);
    }

    @GetMapping("/stop/all")
    public ResponseEntity stopAll() {
        try {
            logger.info("STOP ALL Listener.............");
            Map res = new HashMap();
            SimpleMessageListenerContainer buy = ctxt.getBean("buyContainer", SimpleMessageListenerContainer.class);
            SimpleMessageListenerContainer sell = ctxt.getBean("sellContainer", SimpleMessageListenerContainer.class);
            buy.stop();
            sell.stop();
            res.put("Order.Buy", buy.isRunning());
            res.put("Order.Sell", sell.isRunning());
            return ResponseEntity.ok().body(res);
        } catch (BeansException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/start/all")
    public ResponseEntity startAll() {
        try {
            logger.info("START ALL Listener.............");
            Map res = new HashMap();
            SimpleMessageListenerContainer buy = ctxt.getBean("buyContainer", SimpleMessageListenerContainer.class);
            SimpleMessageListenerContainer sell = ctxt.getBean("sellContainer", SimpleMessageListenerContainer.class);
            buy.start();
            sell.start();
            res.put("Order.Buy", buy.isRunning());
            res.put("Order.Sell", sell.isRunning());
            return ResponseEntity.ok().body(res);
        } catch (BeansException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
