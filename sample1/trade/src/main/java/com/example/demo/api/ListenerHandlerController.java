package com.example.demo.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistry;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@RestController
@RequestMapping("/private")
public class ListenerHandlerController {

    public static final Logger logger = LoggerFactory.getLogger(ListenerHandlerController.class);

    @Autowired
    private ApplicationContext ctxt;

    @GetMapping("/check")
    public ResponseEntity checkState() {
        logger.debug("Check Listener State.............................");
        Map res = new HashMap();
        RabbitListenerEndpointRegistry registry = ctxt.getBean(RabbitListenerEndpointRegistry.class);
        Iterator<String> iterator = registry.getListenerContainerIds().iterator();
        while (iterator.hasNext()) {
            String id = iterator.next();
            res.put(id, registry.getListenerContainer(id).isRunning());
        }
        return ResponseEntity.ok().body(res);
    }

    @GetMapping("/stop/{a}/{b}/{c}")
    public ResponseEntity stop(@PathVariable("a") String gbn, @PathVariable("b") String coin, @PathVariable("c") String market) {
        String msg = "STOP Listener :: GUBUN["+gbn+"] COIN["+coin+"] MARKET["+market+"]";
        try {
            logger.info(msg);
            String id = gbn + "." + coin + "." + market;
            RabbitListenerEndpointRegistry registry = ctxt.getBean(RabbitListenerEndpointRegistry.class);
            registry.getListenerContainer(id).stop();
            return ResponseEntity.ok().body(msg);
        } catch (BeansException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/start/{a}/{b}/{c}")
    public ResponseEntity start(@PathVariable("a") String gbn, @PathVariable("b") String coin, @PathVariable("c") String market) {
        String msg = "START Listener :: GUBUN["+gbn+"] COIN["+coin+"] MARKET["+market+"]";
        try {
            logger.info(msg);
            String id = gbn + "." + coin + "." + market;
            RabbitListenerEndpointRegistry registry = ctxt.getBean(RabbitListenerEndpointRegistry.class);
            registry.getListenerContainer(id).start();
            return ResponseEntity.ok().body(msg);
        } catch (BeansException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/stop/all")
    public ResponseEntity stopAll() {
        try {
            logger.info("STOP ALL Listener.............");
            RabbitListenerEndpointRegistry registry = ctxt.getBean(RabbitListenerEndpointRegistry.class);
            Iterator<String> ids = registry.getListenerContainerIds().iterator();
            while (ids.hasNext()) {
                registry.getListenerContainer(ids.next()).stop();
            }
            return ResponseEntity.ok().body("Stopped All Listener");
        } catch (BeansException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/start/all")
    public ResponseEntity startAll() {
        try {
            logger.info("START ALL Listener.............");
            RabbitListenerEndpointRegistry registry = ctxt.getBean(RabbitListenerEndpointRegistry.class);
            Iterator<String> ids = registry.getListenerContainerIds().iterator();
            while (ids.hasNext()) {
                registry.getListenerContainer(ids.next()).start();
            }
            return ResponseEntity.ok().body("Started All Listener");
        } catch (BeansException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
