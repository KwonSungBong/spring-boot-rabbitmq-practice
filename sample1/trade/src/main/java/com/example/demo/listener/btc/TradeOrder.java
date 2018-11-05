package com.example.demo.listener.btc;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile({"btc", "btc2"})
@Component
public class TradeOrder {

    @RabbitListener(id = "trade.eth.btc", bindings = @QueueBinding(
            value = @Queue(value = "eth.btc.trade", durable = "true"),
            exchange = @Exchange(value = "eth.btc.trade-exchange", type = "topic", durable = "true"),
            key = "eth.btc"),
            containerFactory = "simpleJsonListenerContainerFactory")
    public void receiveETH(Message message) {
        System.out.println(message);
    }

    @RabbitListener(id = "trade.qtum.btc", bindings = @QueueBinding(
            value = @Queue(value = "qtum.btc.trade", durable = "true"),
            exchange = @Exchange(value = "qtum.btc.trade-exchange", type = "topic", durable = "true"),
            key = "qtum.btc"),
            containerFactory = "simpleJsonListenerContainerFactory")
    public void receiveQTUM(Message message) {
        System.out.println(message);
    }

    @RabbitListener(id = "trade.sc.btc", bindings = @QueueBinding(
            value = @Queue(value = "sc.btc.trade", durable = "true"),
            exchange = @Exchange(value = "sc.btc.trade-exchange", type = "topic", durable = "true"),
            key = "sc.btc"),
            containerFactory = "simpleJsonListenerContainerFactory")
    public void receiveSC(Message message) {
        System.out.println(message);
    }

    @RabbitListener(id = "trade.xrp.btc", bindings = @QueueBinding(
            value = @Queue(value = "xrp.btc.trade", durable = "true"),
            exchange = @Exchange(value = "xrp.btc.trade-exchange", type = "topic", durable = "true"),
            key = "xrp.btc"),
            containerFactory = "simpleJsonListenerContainerFactory")
    public void receiveXRP(Message message) {
        System.out.println(message);
    }

    @RabbitListener(id = "trade.npxs.btc", bindings = @QueueBinding(
            value = @Queue(value = "npxs.btc.trade", durable = "true"),
            exchange = @Exchange(value = "npxs.btc.trade-exchange", type = "topic", durable = "true"),
            key = "npxs.btc"),
            containerFactory = "simpleJsonListenerContainerFactory")
    public void receiveNPXS(Message message) {
        System.out.println(message);
    }

    @RabbitListener(id = "trade.gnt.btc", bindings = @QueueBinding(
            value = @Queue(value = "gnt.btc.trade", durable = "true"),
            exchange = @Exchange(value = "gnt.btc.trade-exchange", type = "topic", durable = "true"),
            key = "gnt.btc"),
            containerFactory = "simpleJsonListenerContainerFactory")
    public void receiveGNT(Message message) {
        System.out.println(message);
    }

    @RabbitListener(id = "trade.omg.btc", bindings = @QueueBinding(
            value = @Queue(value = "omg.btc.trade", durable = "true"),
            exchange = @Exchange(value = "omg.btc.trade-exchange", type = "topic", durable = "true"),
            key = "omg.btc"),
            containerFactory = "simpleJsonListenerContainerFactory")
    public void receiveOMG(Message message) {
        System.out.println(message);
    }

    @RabbitListener(id = "trade.gto.btc", bindings = @QueueBinding(
            value = @Queue(value = "gto.btc.trade", durable = "true"),
            exchange = @Exchange(value = "gto.btc.trade-exchange", type = "topic", durable = "true"),
            key = "gto.btc"),
            containerFactory = "simpleJsonListenerContainerFactory")
    public void receiveGTO(Message message) {
        System.out.println(message);
    }

    @RabbitListener(id = "trade.snt.btc", bindings = @QueueBinding(
            value = @Queue(value = "snt.btc.trade", durable = "true"),
            exchange = @Exchange(value = "snt.btc.trade-exchange", type = "topic", durable = "true"),
            key = "snt.btc"),
            containerFactory = "simpleJsonListenerContainerFactory")
    public void receiveSNT(Message message) {
        System.out.println(message);
    }
}