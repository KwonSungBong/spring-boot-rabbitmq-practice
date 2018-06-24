package com.example.demo.component;

import com.example.demo.vo.Order;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class BuyListener implements MessageListener {

    public static final Logger logger = LoggerFactory.getLogger(BuyListener.class);
    public static final ObjectMapper om = new ObjectMapper();

    @Override
    public void onMessage(Message message) {
        String strOrder = new String(message.getBody());
        try {
            logger.info("확인해주세요. :: " + strOrder);
//            Order order = om.readValue(strOrder, Order.class);
//        } catch (IOException e) {
//            e.printStackTrace();
//            logger.info("[매수][ERROR] :: 다시확인해주세요. :: " + strOrder);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("[매수][ERROR] :: " + strOrder);
        }
    }
}
