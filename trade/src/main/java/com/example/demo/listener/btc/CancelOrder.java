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
public class CancelOrder {

    @RabbitListener(id = "cancel.eth.btc", bindings = @QueueBinding(
            value = @Queue(value = "eth.btc.cancel", durable = "true"),
            exchange = @Exchange(value = "eth.btc.cancel-exchange", type = "topic", durable = "true"),
            key = "eth.btc"),
            containerFactory = "simpleJsonListenerContainerFactory")
    public void receiveMessage(Message message) {
        System.out.println(message);
    }

    @RabbitListener(id = "cancel.qtum.btc", bindings = @QueueBinding(
            value = @Queue(value = "qtum.btc.cancel", durable = "true"),
            exchange = @Exchange(value = "qtum.btc.cancel-exchange", type = "topic", durable = "true"),
            key = "qtum.btc"),
            containerFactory = "simpleJsonListenerContainerFactory")
    public void receiveQTUM(Message message) {
        System.out.println(message);
    }

    @RabbitListener(id = "cancel.sc.btc", bindings = @QueueBinding(
            value = @Queue(value = "sc.btc.cancel", durable = "true"),
            exchange = @Exchange(value = "sc.btc.cancel-exchange", type = "topic", durable = "true"),
            key = "sc.btc"),
            containerFactory = "simpleJsonListenerContainerFactory")
    public void receiveSC(Message message) {
        System.out.println(message);
    }

    @RabbitListener(id = "cancel.xrp.btc", bindings = @QueueBinding(
            value = @Queue(value = "xrp.btc.cancel", durable = "true"),
            exchange = @Exchange(value = "xrp.btc.cancel-exchange", type = "topic", durable = "true"),
            key = "xrp.btc"),
            containerFactory = "simpleJsonListenerContainerFactory")
    public void receiveXRP(Message message) {
        System.out.println(message);
    }

    @RabbitListener(id = "cancel.npxs.btc", bindings = @QueueBinding(
            value = @Queue(value = "npxs.btc.cancel", durable = "true"),
            exchange = @Exchange(value = "npxs.btc.cancel-exchange", type = "topic", durable = "true"),
            key = "npxs.btc"),
            containerFactory = "simpleJsonListenerContainerFactory")
    public void receiveNPXS(Message message) {
        System.out.println(message);
    }

    @RabbitListener(id = "cancel.gnt.btc", bindings = @QueueBinding(
            value = @Queue(value = "gnt.btc.cancel", durable = "true"),
            exchange = @Exchange(value = "gnt.btc.cancel-exchange", type = "topic", durable = "true"),
            key = "gnt.btc"),
            containerFactory = "simpleJsonListenerContainerFactory")
    public void receiveGNT(Message message) {
        System.out.println(message);
    }

    @RabbitListener(id = "cancel.omg.btc", bindings = @QueueBinding(
            value = @Queue(value = "omg.btc.cancel", durable = "true"),
            exchange = @Exchange(value = "omg.btc.cancel-exchange", type = "topic", durable = "true"),
            key = "omg.btc"),
            containerFactory = "simpleJsonListenerContainerFactory")
    public void receiveOMG(Message message) {
        System.out.println(message);
    }

    @RabbitListener(id = "cancel.gto.btc", bindings = @QueueBinding(
            value = @Queue(value = "gto.btc.cancel", durable = "true"),
            exchange = @Exchange(value = "gto.btc.cancel-exchange", type = "topic", durable = "true"),
            key = "gto.btc"),
            containerFactory = "simpleJsonListenerContainerFactory")
    public void receiveGTO(Message message) {
        System.out.println(message);
    }

    @RabbitListener(id = "cancel.snt.btc", bindings = @QueueBinding(
            value = @Queue(value = "snt.btc.cancel", durable = "true"),
            exchange = @Exchange(value = "snt.btc.cancel-exchange", type = "topic", durable = "true"),
            key = "snt.btc"),
            containerFactory = "simpleJsonListenerContainerFactory")
    public void receiveSNT(Message message) {
        System.out.println(message);
    }
}
