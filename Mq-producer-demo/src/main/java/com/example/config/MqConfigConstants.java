package com.example.config;

public class MqConfigConstants {

	public static final String MQ_NAMESERVER = "";
	
	public static final String PRODUCE_GROUP = null;

	public static final String PRODUCE_GROUP_NAME = null;
	/**
	 * 定时获取nameservce的topic的信息，默认为30s
	 */
	public static final Integer pollNameServerInteval =30;
	/**
	 * 定时向broker发送心跳 30s，若超时2m会断开连接，清除broker的信息
	 */
	public static int heartbeatBrokerInterval =30;
	
	
}
