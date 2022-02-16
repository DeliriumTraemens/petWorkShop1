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
		return topicRepo.findAllByRoot(true);
	}
	
	public Topic saveRootTopic(String name, String description) {
		Topic newTopic=new Topic();
		newTopic.setName(name);
		newTopic.setDescription(description);
		newTopic.setCreationDate(LocalDateTime.now());
		newTopic.setRoot(true);
		return topicRepo.save(newTopic);
	}
	
	public Topic addNewSubTopic(Long id, String name, String description) {
		Topic fromDb=topicRepo.findById(id).get();
		Topic newSubTopic = new Topic();
			newSubTopic.setName(name);
			newSubTopic.setDescription(description);
			newSubTopic.setCreationDate(LocalDateTime.now());
			newSubTopic.setParentTop(id);
			newSubTopic.setParTop(fromDb);
		return topicRepo.save(newSubTopic);
		
	}
	
	public Topic getTopicById(Long id) {
		return topicRepo.findById(id).get();
	}
	
	public Topic editTopic(Long id, String name, String description) {
		Topic topicFromFront = new Topic();
		Topic topicFromDb = topicRepo.findById(id).get();
		
		if(!name.equals("")){
			topicFromDb.setName(name);
		}
		if(!description.equals("")){
			topicFromDb.setDescription(description);
		}
		
		System.out.println("\n ------------------TopicFromDb -----------");
		System.out.println(topicFromDb);
		return topicRepo.save(topicFromDb);
	}
}
