package com.proptiger.mortgage.worker.consumers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMqConsumer.class);

//    Example -
//    @RabbitListener(queues = RabbitMqConstants.CREATE_SHADOW_LEAD_QUEUE)
//    public void enqueueCreateShadowLeadWorker(Integer leadId){
//        LOGGER.info(
//                "Received request to enqueue Shadow Lead Worker for lead_id - {}",
//                leadId);
////        createShadowLeadWorker.perform(leadId); todo: update this after PR merge
//        LOGGER.debug("createShadowLeadWorker successfully executed for lead_id - {}",
//                leadId);
//    }
}
