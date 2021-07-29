package com.namnx.amqp_demo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmqpFanoutExchangeConfig {

    @Bean
    public Queue marketingQueue() {
        return new Queue("marketingQueue", false);
    }

    @Bean
    public Queue financeQueue() {
        return new Queue("financeQueue", false);
    }

    @Bean
    public Queue adminQueue() {
        return new Queue("adminQueue", false);
    }

    @Bean
    public FanoutExchange exchange() {
        return new FanoutExchange("fanout-exchange");
    }

    @Bean
    Binding marketingBinding(Queue marketingQueue, FanoutExchange exchange) {
        return BindingBuilder.bind(marketingQueue).to(exchange);
    }

    @Bean
    Binding financeBinding(Queue financeQueue, FanoutExchange exchange) {
        return BindingBuilder.bind(financeQueue).to(exchange);
    }

    @Bean
    Binding adminBinding(Queue adminQueue, FanoutExchange exchange) {
        return BindingBuilder.bind(adminQueue).to(exchange);
    }

}