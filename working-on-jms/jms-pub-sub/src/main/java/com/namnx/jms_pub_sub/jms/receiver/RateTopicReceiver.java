package com.namnx.jms_pub_sub.jms.receiver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Message;

@Component
@Slf4j
public class RateTopicReceiver {

    @JmsListener(destination = "${namnx.jms.topic-rate}")
    public void processTopicMessage(Message message){
        log.info(message.toString());
    }
}
