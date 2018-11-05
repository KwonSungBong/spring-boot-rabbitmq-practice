package com.example.demo.listener.fiat;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile({"fiat", "fiat2"})
@Component
public class TradeOrder {

    @RabbitListener(id = "trade.btc.krw", bindings = @QueueBinding(
            value = @Queue(value = "btc.krw.trade", durable = "true"),
            exchange = @Exchange(value = "btc.krw.trade-exchange", type = "topic", durable = "true"),
            key = "btc.krw"),
            containerFactory = "simpleJsonListenerContainerFactory")
    public void receiveBTC(Message message) {
        System.out.println(message);
    }

    @RabbitListener(id = "trade.eth.krw", bindings = @QueueBinding(
            value = @Queue(value = "eth.krw.trade", durable = "true"),
            exchange = @Exchange(value = "eth.krw.trade-exchange", type = "topic", durable = "true"),
            key = "eth.krw"),
            containerFactory = "simpleJsonListenerContainerFactory")
    public void receiveETH(Message message) {
        System.out.println(message);
    }

    @RabbitListener(id = "trade.qtum.krw", bindings = @QueueBinding(
            value = @Queue(value = "qtum.krw.trade", durable = "true"),
            exchange = @Exchange(value = "qtum.krw.trade-exchange", type = "topic", durable = "true"),
            key = "qtum.krw"),
            containerFactory = "simpleJsonListenerContainerFactory")
    public void receiveQTUM(Message message) {
        System.out.println(message);
    }

    @RabbitListener(id = "trade.sc.krw", bindings = @QueueBinding(
            value = @Queue(value = "sc.krw.trade", durable = "true"),
            exchange = @Exchange(value = "sc.krw.trade-exchange", type = "topic", durable = "true"),
            key = "sc.krw"),
            containerFactory = "simpleJsonListenerContainerFactory")
    public void receiveSC(Message message) {
        System.out.println(message);
    }

    @RabbitListener(id = "trade.xrp.krw", bindings = @QueueBinding(
            value = @Queue(value = "xrp.krw.trade", durable = "true"),
            exchange = @Exchange(value = "xrp.krw.trade-exchange", type = "topic", durable = "true"),
            key = "xrp.krw"),
            containerFactory = "simpleJsonListenerContainerFactory")
    public void receiveXRP(Message message) {
        System.out.println(message);
    }

    @RabbitListener(id = "trade.npxs.krw", bindings = @QueueBinding(
            value = @Queue(value = "npxs.krw.trade", durable = "true"),
            exchange = @Exchange(value = "npxs.krw.trade-exchange", type = "topic", durable = "true"),
            key = "npxs.krw"),
            containerFactory = "simpleJsonListenerContainerFactory")
    public void receiveNPXS(Message message) {
        System.out.println(message);
    }

    @RabbitListener(id = "trade.gnt.krw", bindings = @QueueBinding(
            value = @Queue(value = "gnt.krw.trade", durable = "true"),
            exchange = @Exchange(value = "gnt.krw.trade-exchange", type = "topic", durable = "true"),
            key = "gnt.krw"),
            containerFactory = "simpleJsonListenerContainerFactory")
    public void receiveGNT(Message message) {
        System.out.println(message);
    }

    @RabbitListener(id = "trade.omg.krw", bindings = @QueueBinding(
            value = @Queue(value = "omg.krw.trade", durable = "true"),
            exchange = @Exchange(value = "omg.krw.trade-exchange", type = "topic", durable = "true"),
            key = "omg.krw"),
            containerFactory = "simpleJsonListenerContainerFactory")
    public void receiveOMG(Message message) {
        System.out.println(message);
    }

    @RabbitListener(id = "trade.gto.krw", bindings = @QueueBinding(
            value = @Queue(value = "gto.krw.trade", durable = "true"),
            exchange = @Exchange(value = "gto.krw.trade-exchange", type = "topic", durable = "true"),
            key = "gto.krw"),
            containerFactory = "simpleJsonListenerContainerFactory")
    public void receiveGTO(Message message) {
        System.out.println(message);
    }

    @RabbitListener(id = "trade.snt.krw", bindings = @QueueBinding(
            value = @Queue(value = "snt.krw.trade", durable = "true"),
            exchange = @Exchange(value = "snt.krw.trade-exchange", type = "topic", durable = "true"),
            key = "snt.krw"),
            containerFactory = "simpleJsonListenerContainerFactory")
    public void receiveSNT(Message message) {
        System.out.println(message);
    }
}