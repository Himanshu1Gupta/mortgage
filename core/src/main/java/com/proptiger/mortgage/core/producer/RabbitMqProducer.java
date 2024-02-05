package com.proptiger.mortgage.core.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMqProducer.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    public RabbitMqProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public <T> void send(String key, T data) {
        LOGGER.debug(
                "Data ready to be pushed to rabbitmq queue with key: {} and msg: {}", key, data);
        if (data == null) {
            LOGGER.debug("Can't push into queue as null object received ");
            return;
        }
        rabbitTemplate.convertAndSend(key, data);
        LOGGER.info(
                "Data successfully pushed to rabbitmq queue with key: {} and msg: {}", key, data);
    }
}