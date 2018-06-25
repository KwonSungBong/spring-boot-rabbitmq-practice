package com.example.demo.config;

import com.example.demo.vo.Cancel;
import com.example.demo.vo.Trade;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.DefaultClassMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableRabbit
public class RabbitMQConfig {

    @Value("${mq.host}")
    private String rmqHost;
    @Value("${mq.user}")
    private String rmqUser;
    @Value("${mq.pass}")
    private String rmqPass;

    @Bean
    public Jackson2JsonMessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate template = new RabbitTemplate();
        template.setConnectionFactory(connectionFactory());
        template.setMessageConverter(jsonMessageConverter());
        return template;
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
    public SimpleRabbitListenerContainerFactory simpleJsonListenerContainerFactory() {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        DefaultClassMapper classMapper = new DefaultClassMapper();
        Jackson2JsonMessageConverter messageConverter = new Jackson2JsonMessageConverter();
        Map<String, Class<?>> idClassMapping = new HashMap<String, Class<?>>();

        idClassMapping.put("com.example.demo.vo.Trade", Trade.class);
        idClassMapping.put("com.example.demo.vo.Cancel", Cancel.class);
        classMapper.setIdClassMapping(idClassMapping);
        messageConverter.setClassMapper(classMapper);
        factory.setConnectionFactory(connectionFactory());
        factory.setMessageConverter(messageConverter);
        factory.setMessageConverter(messageConverter);
        return factory;
    }

}