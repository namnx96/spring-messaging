package com.namnx.amqp_demo.amqp.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RpcClient {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public Object sendMessage(String exchange,
                              String routingKey,
                              String message) {
        return rabbitTemplate.convertSendAndReceive(exchange, routingKey, message);
    }
}
