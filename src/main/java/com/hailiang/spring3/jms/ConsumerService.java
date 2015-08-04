package com.hailiang.spring3.jms;


public interface ConsumerService {

	public void receiveMqMsg(String msg) throws Exception;
	
}
