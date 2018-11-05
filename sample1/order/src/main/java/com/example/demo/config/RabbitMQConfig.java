package com.example.demo.config;

import com.example.demo.component.BuyListener;
import com.example.demo.component.SellListener;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

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

    @Value("${rmq.host}")
    private String rmqHost;
    @Value("${rmq.user}")
    private String rmqUser;
    @Value("${rmq.pass}")
    private String rmqPass;

    @Bean
    public Jackson2JsonMessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory factory = new CachingConnectionFactory();
        factory.setAddresses(rmqHost);
        factory.setUsername(rmqUser);
        factory.setPassword(rmqPass);
        return factory;
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate template = new RabbitTemplate(connectionFactory());
        template.setConnectionFactory(connectionFactory());
        template.setMessageConverter(jsonMessageConverter());
        return template;
    }

    /**
     * BUY
     */
    @Bean
    public SimpleMessageListenerContainer buyContainer(BuyListener buyListener) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setListenerId("ORDER.BUY");
        container.setConnectionFactory(connectionFactory());
        container.setQueueNames(ORDER_BUY_QUEUE);
        container.setMessageListener(buyListener);
        container.setMessageConverter(jsonMessageConverter());
        return container;
    }
    @Bean
    public BuyListener buyListener() {
        return new BuyListener();
    }
    @Bean
    public Queue buyQueue() {
        return new Queue(ORDER_BUY_QUEUE);
    }
    @Bean
    public TopicExchange exchangeBuyOrder() {
        return new TopicExchange(ORDER_BUY_EXCHANGE);
    }
    @Bean
    public Binding bindingBuy(Queue buyQueue) {
        return BindingBuilder.bind(buyQueue).to(exchangeBuyOrder()).with(ROUTING_KEY);
    }

    /**
     * SELL
     */
    @Bean
    public SimpleMessageListenerContainer sellContainer(SellListener sellListener) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setListenerId("ORDER.SELL");
        container.setConnectionFactory(connectionFactory());
        container.setQueueNames(ORDER_SELL_QUEUE);
        container.setMessageListener(sellListener);
        container.setMessageConverter(jsonMessageConverter());
        return container;
    }
    @Bean
    public SellListener sellListener() {
        return new SellListener();
    }
    @Bean
    public Queue sellQueue() {
        return new Queue(ORDER_SELL_QUEUE);
    }
    @Bean
    public TopicExchange exchangeSellOrder() {
        return new TopicExchange(ORDER_SELL_EXCHANGE);
    }
    @Bean
    public Binding bindingsell(Queue sellQueue) {
        return BindingBuilder.bind(sellQueue).to(exchangeSellOrder()).with(ROUTING_KEY);
    }
    
}
