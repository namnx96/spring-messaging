package com.namnx.amqp_demo.amqp.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Consumer {

    @RabbitListener(queues = "${amqp.queue}")
    public void processMessage(Message message) {
        log.info(message.toString());
    }

    @RabbitListener(queues = {"adminQueue", "financeQueue", "marketingQueue"})
    public void processMessageFromFanoutExchange(Message message) {
        log.info(message.toString());
    }
}
