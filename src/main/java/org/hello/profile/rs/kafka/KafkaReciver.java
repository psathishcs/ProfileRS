package org.hello.profile.rs.kafka;

import java.util.concurrent.CountDownLatch;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class KafkaReciver {
	private static final Logger LOGGER  = LoggerFactory.getLogger(KafkaReciver.class);
	private CountDownLatch latch = new CountDownLatch(1);
	
	public CountDownLatch getLatch() {
		return latch;
	}
	
	@KafkaListener(topics = "${spring.kafka.topics.boot}")
	public void receive(ConsumerRecord<?, ?> consumerRecord) {
		LOGGER.info("receiyed Payload = '{}'", consumerRecord.toString());
	}

}
