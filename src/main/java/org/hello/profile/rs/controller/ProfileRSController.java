package org.hello.profile.rs.controller;

import org.hello.profile.rs.data.Profile;
import org.hello.profile.rs.kafka.KafkaSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
public class ProfileRSController {
	
	@Value("${spring.kafka.topics.boot}")
	private String topic = "boot.test";
	
	@Autowired
	private KafkaSender kafkaSender;
	
	private Gson gson = new Gson();
	
	@RequestMapping(value = "/profile", method = RequestMethod.POST)
	public Boolean PushToKafka(@RequestBody Profile profile) {
		kafkaSender.send(topic, gson.toJson(profile));
		return true;
	}

}
