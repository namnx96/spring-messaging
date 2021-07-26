package com.namnx.jms_sender.jms.receiver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.MessageListener;

@Component
@Slf4j
public class QueueMessageListener implements MessageListener {

    @Override
    public void onMessage(Message message) {
        log.info("Get message from queue: {}", message.toString());
    }
}
