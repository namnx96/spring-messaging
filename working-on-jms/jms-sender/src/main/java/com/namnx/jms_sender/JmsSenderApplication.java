package com.namnx.jms_sender;

import com.namnx.jms_sender.domain.Rate;
import com.namnx.jms_sender.jms.JMSProperties;
import com.namnx.jms_sender.jms.sender.RateSender;
import com.namnx.jms_sender.jms.sender.SimpleJmsSender;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@ConfigurationPropertiesScan
@SpringBootApplication
public class JmsSenderApplication {

    public static void main(String[] args) {
        SpringApplication.run(JmsSenderApplication.class, args);
    }

    @Bean
    CommandLineRunner simple(JMSProperties props,
                             SimpleJmsSender sender,
                             RateSender rateSender){
        return args -> {
            sender.sendMessage(props.getQueue(), "Hello World");
            rateSender.sendCurrency(props.getRateQueue(), new Rate("1", 55.0f, new Date()));
        };
    }
}
