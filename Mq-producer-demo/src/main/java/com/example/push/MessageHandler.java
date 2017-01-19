package com.example.push;

import com.alibaba.rocketmq.client.producer.SendResult;
/**
 * 
 * @author lw
 *
 */
public interface MessageHandler {
	/**
	 * 发送成功返回 true
	 * @param result
	 * @return
	 */
	public boolean handerMessage(SendResult result);
}
