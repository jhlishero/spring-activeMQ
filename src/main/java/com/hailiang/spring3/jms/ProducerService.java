package com.hailiang.spring3.jms;

import javax.jms.Destination;

public interface ProducerService {

	/**
	 * 发送消息
	 * @author hailiang.jiang
	 * @date 2015年7月30日 下午12:27:35
	 * @param destination
	 * @param message
	 */
	public void sendMessage(Destination destination, final String message);
	
}
