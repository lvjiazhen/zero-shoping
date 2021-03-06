package com.zero.base.jms.config;

import javax.jms.ConnectionFactory;

import lombok.Data;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

@Configuration
@EnableJms
public class JmsConfig {
	
	@Value("${spring.activemq.broker-url}")
	private String brokerURL ;
	
	@Value("spring.activemq.user}")
	private String userName ;
	
	@Value("${spring.activemq.password}")
	private String password ;
	
	@Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory());
       // factory.setDestinationResolver(destinationResolver());
        factory.setSessionTransacted(true);
    
     //   factory.setConcurrency("3-10");
        return factory;
    }

	@Bean
	public ConnectionFactory connectionFactory() {
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(userName,password,brokerURL);
		return connectionFactory;
	}
	
	@Bean
	public JmsTemplate jmsTemplate() {
		JmsTemplate jmsTemplate = new JmsTemplate();
		jmsTemplate.setConnectionFactory(connectionFactory());
		return jmsTemplate;
	}
	
	
}
