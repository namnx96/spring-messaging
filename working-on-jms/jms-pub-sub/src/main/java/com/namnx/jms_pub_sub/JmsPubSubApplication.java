package com.namnx.jms_pub_sub;

import com.namnx.jms_pub_sub.domain.Rate;
import com.namnx.jms_pub_sub.jms.JMSProperties;
import com.namnx.jms_pub_sub.jms.sender.RateSender;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@ConfigurationPropertiesScan
@SpringBootApplication
public class JmsPubSubApplication {

    public static void main(String[] args) {
        SpringApplication.run(JmsPubSubApplication.class, args);
    }

    @Bean
    CommandLineRunner simple(JMSProperties props,
                             RateSender rateSender) {
        return args -> {
            rateSender.sendCurrency(props.getTopicRate(), new Rate("1", 55.0f, new Date()));
            rateSender.sendCurrency(props.getTopicRate(), new Rate("2", 10000f, new Date()));
        };
    }
}
