package com.namnx.jms_sender.jms.receiver;

import com.namnx.jms_sender.domain.Rate;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Component
public class RateReplyListener {

    @JmsListener(destination = "${namnx.jms.rate-queue}")
    @SendTo("${namnx.jms.rate-reply-queue}")
    public Message<String> processRate(Rate rate) {

        //Process the Rate and return any significant value
        return MessageBuilder
                .withPayload("PROCCESSED")
                .setHeader("CODE", rate.getCode())
                .setHeader("RATE", rate.getRateVal())
                .setHeader("ID", UUID.randomUUID().toString())
                .setHeader("DATE", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
                .build();
    }
}