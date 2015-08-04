package com.hailiang.spring3.jms;

import javax.jms.Destination;

import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hailiang.spring3.TestRootApplication;

public class ProducerServiceTest extends TestRootApplication {

	@Autowired
	private ProducerService producerService;
	
	@Test
	public void testActiveMQProducer() {
		Destination dest = new ActiveMQQueue("test.salesorder.queue");
		for (int i = 0; i < 10; i++) {
			producerService.sendMessage(dest, String.format("你好，这是生成消息_%d", i + 1));
		}
	}
	
}
