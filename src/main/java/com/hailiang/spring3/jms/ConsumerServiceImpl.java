package com.hailiang.spring3.jms;

import org.springframework.stereotype.Service;

@Service("consumerService")
public class ConsumerServiceImpl implements ConsumerService {
	
	public static int i = 0;

	@Override
	public void receiveMqMsg(String msg) throws Exception {
		System.out.println("****consumer****" + msg); 
		if (i == 5) {
			throw new Exception("xcvsdfsdfsd");
		}
		i ++;
	}
	
}
