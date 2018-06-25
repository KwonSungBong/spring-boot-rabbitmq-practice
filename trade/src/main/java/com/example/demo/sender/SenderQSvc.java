package com.example.demo.sender;

import com.example.demo.vo.Cancel;
import com.example.demo.vo.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SenderQSvc {

    private Logger logger = LoggerFactory.getLogger(SenderQSvc.class);

    @Autowired
    RabbitTemplate rabbitTemplate;

    public void txBuyRes(Order orderVO) {
        String routingKey = "";
        String resBuyExchange = routingKey + ".res-buy-exchange";
        logger.info("TRADE :: RES :: BUY :: ["+resBuyExchange+"] :: " + orderVO);
        rabbitTemplate.convertAndSend(resBuyExchange, routingKey, orderVO);
    }

    public void txSellRes(Order orderVO) {
        String routingKey = "";
        String resSellExchange = routingKey + ".res-sell-exchange";
        logger.info("TRADE :: RES :: SELL :: ["+resSellExchange+"] :: " + orderVO);
        rabbitTemplate.convertAndSend(resSellExchange, routingKey, orderVO);
    }

    public void resWithdrawBuy(Cancel vo) {
        String routingKey = "";
        String resBuyExchange = routingKey + ".res-buy-exchange";
        logger.info("TRADE :: RES :: SELL :: ["+resBuyExchange+"] :: " + vo);
        rabbitTemplate.convertAndSend(resBuyExchange, routingKey, vo);
    }

    public void resWithdrawSell(Cancel vo) {
        String routingKey = "";
        String resSellExchange = routingKey + ".res-sell-exchange";
        logger.info("TRADE :: RES :: SELL :: ["+resSellExchange+"] :: " + vo);
        rabbitTemplate.convertAndSend(resSellExchange, routingKey, vo);
    }

}
