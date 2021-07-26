package com.namnx.jms_sender.jms;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@ConfigurationProperties(prefix="namnx.jms")
@Getter
@Setter
public class JMSProperties {

	private String queue;
	private String rateQueue;
	private String rateReplyQueue;
	private String topic;

}
