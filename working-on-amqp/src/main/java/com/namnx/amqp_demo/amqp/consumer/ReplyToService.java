package com.namnx.amqp_demo.amqp.consumer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class ReplyToService {

	@RabbitListener(queues="${amqp.queue}")
	@SendTo("${amqp.reply-queue}")
	public Message<String> replyToProcess(String message){
		return MessageBuilder
		        .withPayload("PROCESSED:OK")
		        .setHeader("PROCESSED", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
		        .setHeader("CODE", UUID.randomUUID().toString())
				.setHeader("DATA", message)
		        .build();
	}
	
}
