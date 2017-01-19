package com.example.push;

import net.sf.json.JSONObject;

import com.alibaba.rocketmq.client.producer.SendResult;
/**
 * 得到处理的结果的状态sucess or failure
 * @author lw
 *
 */
public class DefaultMessageHandler implements MessageHandler{

	@Override
	public boolean handerMessage(SendResult result) {
		if(result == null) return false;
		
		JSONObject jsonObject = JSONObject.fromObject(result);
		
		if (jsonObject.get("result") != null && jsonObject.getString("result").equalsIgnoreCase("SEND_OK")) {
			
			return true;
		}
		
		return false;
	}

}
