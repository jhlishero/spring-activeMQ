package com.hailiang.spring3.jms;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

public class JmsTest {

	@Test
	public void test() throws JMSException {
		String brokerURL = "failover:(tcp://10.8.12.133:61616)?initialReconnectDelay=3000";
		String username = "system";
		String password = "bizhubsys201404";
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(username, password, brokerURL);
		Connection connection = connectionFactory.createConnection();
		connection.start();
		
		Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
		boolean topic = false;
		
		Destination destination = null;
		String subject = "test.quenue1";
		if (topic) {
			destination = session.createTopic(subject);
		} else {
			destination = session.createQueue(subject);
		}
		
		MessageProducer producer = session.createProducer(destination);
		boolean persistent = true;
		if (persistent) {  
		      producer.setDeliveryMode(DeliveryMode.PERSISTENT);  
		} else {  
		      producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);  
		}
		int timeToLive = 0;
		if (timeToLive != 0) {  
		       producer.setTimeToLive(timeToLive);  
		}   
		
		TextMessage message = session.createTextMessage("createMessageText");
		producer.send(message);
		producer.close();
	}
	
}
