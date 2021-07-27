package com.namnx.jms_pub_sub.jms.sender;

import com.namnx.jms_pub_sub.domain.Rate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class RateSender {

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendCurrency(String destination, Rate rate) {
        this.jmsTemplate.convertAndSend(destination, rate);
    }
}
