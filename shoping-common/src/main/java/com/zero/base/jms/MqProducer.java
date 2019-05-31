package com.zero.base.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component
public class MqProducer {
	@Autowired
	private JmsTemplate jmsTemplate;

	public void SendMessage(String destination, String text) {
		jmsTemplate.send(destination, new MessageCreator() {

			@Override
			public Message createMessage(Session session) throws JMSException {
			//	session.createTextMessage(text);
			//	return null;
				session.createTextMessage(text);
				return null ;
			}
		});
	}

}
