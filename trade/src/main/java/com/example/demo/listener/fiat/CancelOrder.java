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
public class CancelOrder {

    @RabbitListener(id = "cancel.btc.krw", bindings = @QueueBinding(
            value = @Queue(value = "btc.krw.cancel", durable = "true"),
            exchange = @Exchange(value = "btc.krw.cancel-exchange", type = "topic", durable = "true"),
            key = "btc.krw"),
            containerFactory = "simpleJsonListenerContainerFactory")
    public void receiveBTC(Message message) {
        System.out.println(message);
    }

    @RabbitListener(id = "cancel.eth.krw", bindings = @QueueBinding(
            value = @Queue(value = "eth.krw.cancel", durable = "true"),
            exchange = @Exchange(value = "eth.krw.cancel-exchange", type = "topic", durable = "true"),
            key = "eth.krw"),
            containerFactory = "simpleJsonListenerContainerFactory")
    public void receiveETH(Message message) {
        System.out.println(message);
    }

    @RabbitListener(id = "cancel.qtum.krw", bindings = @QueueBinding(
            value = @Queue(value = "qtum.krw.cancel", durable = "true"),
            exchange = @Exchange(value = "qtum.krw.cancel-exchange", type = "topic", durable = "true"),
            key = "qtum.krw"),
            containerFactory = "simpleJsonListenerContainerFactory")
    public void receiveQTUM(Message message) {
        System.out.println(message);
    }

    @RabbitListener(id = "cancel.sc.krw", bindings = @QueueBinding(
            value = @Queue(value = "sc.krw.cancel", durable = "true"),
            exchange = @Exchange(value = "sc.krw.cancel-exchange", type = "topic", durable = "true"),
            key = "sc.krw"),
            containerFactory = "simpleJsonListenerContainerFactory")
    public void receiveSC(Message message) {
        System.out.println(message);
    }

    @RabbitListener(id = "cancel.xrp.krw", bindings = @QueueBinding(
            value = @Queue(value = "xrp.krw.cancel", durable = "true"),
            exchange = @Exchange(value = "xrp.krw.cancel-exchange", type = "topic", durable = "true"),
            key = "xrp.krw"),
            containerFactory = "simpleJsonListenerContainerFactory")
    public void receiveXRP(Message message) {
        System.out.println(message);
    }

    @RabbitListener(id = "cancel.npxs.krw", bindings = @QueueBinding(
            value = @Queue(value = "npxs.krw.cancel", durable = "true"),
            exchange = @Exchange(value = "npxs.krw.cancel-exchange", type = "topic", durable = "true"),
            key = "npxs.krw"),
            containerFactory = "simpleJsonListenerContainerFactory")
    public void receiveNPXS(Message message) {
        System.out.println(message);
    }

    @RabbitListener(id = "cancel.omg.krw", bindings = @QueueBinding(
            value = @Queue(value = "omg.krw.cancel", durable = "true"),
            exchange = @Exchange(value = "omg.krw.cancel-exchange", type = "topic", durable = "true"),
            key = "omg.krw"),
            containerFactory = "simpleJsonListenerContainerFactory")
    public void receiveOMG(Message message) {
        System.out.println(message);
    }

    @RabbitListener(id = "cancel.gto.krw", bindings = @QueueBinding(
            value = @Queue(value = "gto.krw.cancel", durable = "true"),
            exchange = @Exchange(value = "gto.krw.cancel-exchange", type = "topic", durable = "true"),
            key = "gto.krw"),
            containerFactory = "simpleJsonListenerContainerFactory")
    public void receiveGTO(Message message) {
        System.out.println(message);
    }

    @RabbitListener(id = "cancel.snt.krw", bindings = @QueueBinding(
            value = @Queue(value = "snt.krw.cancel", durable = "true"),
            exchange = @Exchange(value = "snt.krw.cancel-exchange", type = "topic", durable = "true"),
            key = "snt.krw"),
            containerFactory = "simpleJsonListenerContainerFactory")
    public void receiveSNT(Message message) {
        System.out.println(message);
    }
}
