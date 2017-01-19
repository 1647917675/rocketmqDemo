package com.example.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.example.push.MessageHandler;
import com.example.util.ProducerInstanceFactory;

@Configurable
public class MqConfig {

	@Bean
	public DefaultMQProducer  getProducer(){
		return ProducerInstanceFactory.GetProduce();
	}
	
	@Bean 
	MessageHandler getMessageHandler(){
		return (MessageHandler) new DefaultMQProducer();
	}
}
