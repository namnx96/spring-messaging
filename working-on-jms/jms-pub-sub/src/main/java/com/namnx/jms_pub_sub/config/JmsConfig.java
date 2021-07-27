package com.namnx.jms_pub_sub.config;

import org.springframework.boot.autoconfigure.jms.JmsProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@Configuration
@EnableConfigurationProperties(JmsProperties.class)
public class JmsConfig {

    @Bean
    public MessageConverter jacksonJmsMessageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);

        // This is an important setting, because it will drive
        //the way the mapping is done behind the scenes. This can be any value you
        //want. It’s just a simple identifier that will hold the qualified class name that
        //is being mapped.
        converter.setTypeIdPropertyName("_class_");
        return converter;
    }
}