package com.example.util;

import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.example.config.MqConfigConstants;

public class ProducerInstanceFactory {
 
	private static DefaultMQProducer producer;

	private static void bornProduce(){
		producer = new DefaultMQProducer(MqConfigConstants.PRODUCE_GROUP_NAME);
		producer.setNamesrvAddr(MqConfigConstants.MQ_NAMESERVER);
		producer.setPollNameServerInteval(MqConfigConstants.pollNameServerInteval);
		producer.setHeartbeatBrokerInterval(MqConfigConstants.heartbeatBrokerInterval);
		//producer.setInstanceName(instanceName);
		//这三个配置自己是否开启自己配置一下
		//producer.setRetryTimesWhenSendFailed(retryTimesWhenSendFailed);
		//producer.setSendMsgTimeout(sendMsgTimeout);
		//producer.setRetryAnotherBrokerWhenNotStoreOK(retryAnotherBrokerWhenNotStoreOK);
		 
		try {
			producer.start();
		} catch (MQClientException e) {
			e.printStackTrace();
		}
	}
	
	public static DefaultMQProducer GetProduce(){
		if (producer == null) {
			bornProduce();
		}
		return producer;
	}
}
