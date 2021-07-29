package com.namnx.amqp_demo.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(AmqpProperties.class)
public class AmqpDirectExchangeConfig {

    @Bean
    public Queue queue(@Value("${amqp.queue}") String queueName) {
        return new Queue(queueName, false);
    }

    @Bean
    public Queue replyQueue(@Value("${amqp.reply-queue}") String queueName) {
        return new Queue(queueName, false);
    }

}
