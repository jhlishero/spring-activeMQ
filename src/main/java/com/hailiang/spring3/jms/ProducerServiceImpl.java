package com.hailiang.spring3.jms;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

@Service("producerService")
public class ProducerServiceImpl implements ProducerService {
	
	@Autowired
	private JmsTemplate jmsTemplate;
	

	@Override
	public void sendMessage(Destination destination, final String message) {
        System.out.println("====producer====" + message);   
        jmsTemplate.send(destination, new MessageCreator() {   
            public Message createMessage(Session session) throws JMSException {   
                return session.createTextMessage(message);   
            }   
        }); 
	}
	
}
