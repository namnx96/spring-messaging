package com.namnx.amqp_demo;

import com.namnx.amqp_demo.amqp.producer.Producer;
import com.namnx.amqp_demo.amqp.producer.RpcClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringAmqpApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAmqpApplication.class, args);
    }

    @Bean
    CommandLineRunner simple(@Value("${amqp.exchange:}") String exchange,
                             @Value("${amqp.queue}") String routingKey,
                             Producer producer,
                             RpcClient rpcClient) {
        return args -> {
            producer.sendMessage(exchange, routingKey, "HELLO AMQP!");
            Object result = rpcClient.sendMessage(exchange, routingKey, "HELLO AMQP/RPC!");
            assert result != null;

            producer.sendMessageToFanoutExchange("fanout-exchange", "Hello fanout exchange");
        };
    }

}
