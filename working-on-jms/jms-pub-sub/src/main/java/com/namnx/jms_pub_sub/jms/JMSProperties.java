package com.namnx.jms_pub_sub.jms;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@ConfigurationProperties(prefix="namnx.jms")
@Getter
@Setter
public class JMSProperties {
	private String topicRate;

}
