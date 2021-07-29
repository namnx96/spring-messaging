package com.namnx.amqp_demo.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="amqp")
@Getter
@Setter
public class AmqpProperties {

	private String queue;
	private String exchange = "";
}
