package com.zero.base.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component("com.zero.base.jms.MqConsumer")
public class MqConsumer {

	@JmsListener(destination = JmsConstants.ORDER_DESTINATION_NAME1)
	public void test(Message massage) throws JMSException, InterruptedException{
		TextMessage textMessage = (TextMessage)massage;
		System.out.println(textMessage.getText());
		System.out.println(Thread.currentThread().getName());
		Thread.sleep(1000*60);
		
	}
	
	@JmsListener(destination = JmsConstants.ORDER_DESTINATION_NAME2)
	public void test2(Message massage) throws JMSException{
		TextMessage textMessage = (TextMessage)massage;
		System.out.println(textMessage.getText());
		System.out.println(Thread.currentThread().getName());
		
	}
	
}
