package com.namnx.jms_sender.config;

import com.namnx.jms_sender.jms.JMSProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@Configuration
@EnableConfigurationProperties(JMSProperties.class)
public class JmsConfig {

    @Value("${namnx.jms.queue}")
    private String destinationName;

/*    set default listener
    @Bean
    public DefaultMessageListenerContainer customMessageListenerContainer(ConnectionFactory connectionFactory,
                                                                          MessageListener queueListener) {
        DefaultMessageListenerContainer listener = new DefaultMessageListenerContainer();
        listener.setConnectionFactory(connectionFactory);
        listener.setDestinationName(destinationName);
        listener.setMessageListener(queueListener);
        return listener;
    }*/


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