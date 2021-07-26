package com.namnx.jms_sender.jms.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class SimpleJmsSender {

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendMessage(String destination,
                            String message) {
        this.jmsTemplate.convertAndSend(destination, message);
    }
}
