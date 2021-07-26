package com.namnx.jms_sender.jms.receiver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Message;

@Component
@Slf4j
public class AnnotatedReceiver {

    @JmsListener(destination = "${namnx.jms.queue}")
    public void processMessage(Message message){
        log.info(message.toString());
    }

    @JmsListener(destination = "${namnx.jms.rate-queue}")
    public void processRateQueueMessage(Message message){
        log.info(message.toString());
    }
}
