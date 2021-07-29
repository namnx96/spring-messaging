package com.namnx.amqp_demo.amqp.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Component
@Slf4j
public class RpcServer {

    @RabbitListener(queues = "${amqp.queue}")
    public Message<String> process(String message) {
        log.info(message);
        return MessageBuilder
                .withPayload("PROCESSED:OK")
                .setHeader("PROCESSED", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
                .setHeader("CODE", UUID.randomUUID().toString())
                .build();
    }
}
