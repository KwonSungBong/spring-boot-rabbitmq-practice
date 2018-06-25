package com.example.demo.config;

import java.util.HashMap;
import java.util.Map;

import com.example.demo.config.WalletMQListenerContainer;
import com.example.demo.listener.WalletListener;
import com.example.demo.vo.CURRENCY;
import com.example.demo.vo.WithdrawINVO;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.DefaultClassMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@EnableRabbit
public class RabbitMQConfig {

    public static final String ROUTING_KEY = "wallet";

    public static final String QUEUE_WALLET_UPDATE = "wallet.update";

    public static final String EXCHANGE_WALLET_UPDATE = "wallet.update-exchange";

    public static final long MAX_COUNT = 10;

    @Value("${mq.host}")
    private String host;

    @Value("${mq.user}")
    private String user;

    @Value("${mq.pass}")
    private String pass;

    @Value("${mq.listener}")
    private String modNumbers;

    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate template = new RabbitTemplate();
        template.setRoutingKey(ROUTING_KEY);
        template.setConnectionFactory(connectionFactory());
        template.setMessageConverter(jsonMessageConverter());
        return template;
    }

    @Bean
    public Queue walletQueue() {
        return new Queue(QUEUE_WALLET_UPDATE);
    }

    @Bean
    public Binding bindingWalletQueue(Queue walletQueue) {
        return BindingBuilder.bind(walletQueue).to(exchangeWallet()).with(ROUTING_KEY);
    }

    @Bean
    public TopicExchange exchangeWallet() { return new TopicExchange(EXCHANGE_WALLET_UPDATE); }

    @Bean
    public Jackson2JsonMessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public WalletMQListenerContainer walletContainer() {
        WalletMQListenerContainer container = new WalletMQListenerContainer();
        container.setConnectionFactory(connectionFactory());
        for(CURRENCY crncyCd : CURRENCY.crncyCdList()) {
            container.addQueue(ROUTING_KEY, crncyCd.name().toLowerCase(), modNumbers);
        }
        container.setMessageListener(walletListener());
        container.setMessageConverter(getMessageConverter());

        return container;
    }

    @Bean
    public WalletListener walletListener() {
        return new WalletListener();
    }

    public Jackson2JsonMessageConverter getMessageConverter() {
        Jackson2JsonMessageConverter messageConverter = new Jackson2JsonMessageConverter();

        DefaultClassMapper classMapper = new DefaultClassMapper();
        Map<String, Class<?>> idClassMapping = new HashMap<String, Class<?>>();
        idClassMapping.put("com.example.demo.vo.WithdrawINVO", WithdrawINVO.class);

        classMapper.setIdClassMapping(idClassMapping);
        messageConverter.setClassMapper(classMapper);
        return messageConverter;
    }

    @Bean
    @Primary
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory factory = new CachingConnectionFactory();
        factory.setAddresses(host);
        factory.setUsername(user);
        factory.setPassword(pass);
        return factory;
    }

}
