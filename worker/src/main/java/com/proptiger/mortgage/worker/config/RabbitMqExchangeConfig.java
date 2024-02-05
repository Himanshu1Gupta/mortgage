package com.proptiger.mortgage.worker.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqExchangeConfig {

    @Value("${spring.rabbitmq.template.exchange}")
    private String topicExchangeName;

    @Bean
    TopicExchange advertTopicExchange() {
        return new TopicExchange(topicExchangeName);
    }

//    Example -
//    @Bean
//    Queue syncListingCountQueue() {
//        return new Queue(RabbitMqConstants.CREATE_SHADOW_LEAD_QUEUE, true);
//    }
//
//    @Bean
//    Binding syncListingCountBinding() {
//        return BindingBuilder.bind(syncListingCountQueue())
//                .to(advertTopicExchange())
//                .with(RabbitMqConstants.CREATE_SHADOW_LEAD_KEY);
//    }

}
