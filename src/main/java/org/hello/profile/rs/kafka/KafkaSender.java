package org.hello.profile.rs.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class KafkaSender {
	private static final Logger LOGGER  = LoggerFactory.getLogger(KafkaSender.class);
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public void send(String topic, String payload) {
		LOGGER.info("Sending Payload = '{}' to topic = '{}'", payload, topic);
		kafkaTemplate.send(topic, payload);
	}

}
