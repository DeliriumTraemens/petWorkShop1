package org.mycola.petWorkShop1.service;

import org.mycola.petWorkShop1.domain.Topic;
import org.mycola.petWorkShop1.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TopicService {
	private final TopicRepository topicRepo;
	
	@Autowired
	public TopicService(TopicRepository topicRepo) {
		this.topicRepo = topicRepo;
	}
	
	public List<Topic> getTopicList() {
		return topicRepo.findAll();
	}
	
	public Topic saveTopic(String name, String description) {
		Topic newTopic=new Topic();
		newTopic.setName(name);
		newTopic.setDescription(description);
		newTopic.setCreationDate(LocalDateTime.now());
		newTopic.setRoot(true);
		return topicRepo.save(newTopic);
	}
}
