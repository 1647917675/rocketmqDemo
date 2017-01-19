package com.example.producerSelector;

import java.util.List;

import com.alibaba.rocketmq.client.producer.MessageQueueSelector;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.common.message.MessageQueue;
/***
 * 
 * 根据生产者生产出来key的hashcode将messagequeue分离处理  
 * 
 * 
 * problem：
 * 		1.消息存储导致负载均衡的问题
 * 		2.一些Messagequeue可能是无法使用	key数组的值必须和list<MessageQueue>的size是相等的
 * 
 * @author lw
 *
 */
public class DemoStrageImplByHasH implements MessageQueueSelector{

	@Override
	public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
		// TODO Auto-generated method stub
		
		int MessagequeueIndex = msg.getKeys().hashCode() % mqs.size();
		
		return mqs.get(MessagequeueIndex);
	}

}
