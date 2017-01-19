package com.example.push;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.remoting.exception.RemotingException;

@RestController
public class ProducerController {

	private Logger Log = LoggerFactory.getLogger(ProducerController.class);
	private List<Message> exceptionQueue = new LinkedList<Message>();
	
	@Autowired
	private DefaultMQProducer producer;
	@Autowired
	private MessageHandler handler;
	/**
	 * 发送message
	 * @param message
	 * @return
	 */
	public boolean sendMessage(Message message){
		SendResult sendResult = null;
		try {
			sendResult = producer.send(message);
		} catch (MQClientException | RemotingException | MQBrokerException
				| InterruptedException e) {
			exceptionQueue.add(message);
			Log.error("ProducerController send message cause the error:{}",e.getStackTrace());
		}
		//这里处理失败了可以自己定义实现，自己去去处理数据，是重新发送还是其他的
		return handler.handerMessage(sendResult);
	}
}
