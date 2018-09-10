package com.accenture.avs.device.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.accenture.avs.be.jms.client.AvsJmsProducer;
import com.accenture.avs.be.jms.client.dto.AvsMessage;
import com.accenture.avs.commons.lib.LoggerWrapper;

/**
 * 
 * @author anand.jha
 *
 */

@Component
public class AvsJmsProducerUtil {
	
	/** Instance of LoggerWrapper for logging purpose */
	private static final LoggerWrapper LOGGER = new LoggerWrapper(AvsJmsProducerUtil.class);
	
	/** avsBeQueueEndPoint */
	@Value("${avsbe.queue.endPoint}")
	private String avsBeQueueEndPoint;
	
	/** avsBeQueuePassword */
	@Value("${avsbe.queue.password}")
	private String avsBeQueuePassword;
	
	/** avsBeQueueUsername */
	@Value("${avsbe.queue.userName}")
	private String avsBeQueueUserName;
	
	/** avsBeQueueName */
	@Value("${avsbe.groupms.queue}")
	private String avsBeGroupmsQueue;
	
	private int messagePriority= 5;
	
	@PostConstruct
	public void init(){
		try {
			AvsJmsProducer.initializeJmsSession(avsBeQueueEndPoint, avsBeQueueUserName, avsBeQueuePassword);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LOGGER.logError(e);
		}
	}
	
	/**
	 * 
	 * @param userNames
	 */
	public void sendMessageToGroupMs(String operation, List<String> userNames){
		Map<String, Object> messageMap = new HashMap<>();
		messageMap.put("userNames", userNames);
		AvsMessage avsMessage = new AvsMessage(operation, messageMap);
		try {
			LOGGER.logMessage("Sending message to Group Definition Ms......");
			
			AvsJmsProducer.sendMessage(avsBeGroupmsQueue, messagePriority, avsMessage);
			
			LOGGER.logMessage("Message has been successfully sent to Group Ms.");
		} catch (Exception e) {
			LOGGER.logError(e);
		}
	}

}
