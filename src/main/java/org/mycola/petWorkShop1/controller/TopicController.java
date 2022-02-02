package org.mycola.petWorkShop1.controller;

import org.mycola.petWorkShop1.domain.Topic;
import org.mycola.petWorkShop1.service.TopicService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topic")
@CrossOrigin("*")
public class TopicController {
	private final TopicService topicService;
	
	
	public TopicController(TopicService topicService) {
		this.topicService = topicService;
	}
	
	@GetMapping
	public List<Topic> getTopics(){
		return topicService.getTopicList();
	}
	
	@PostMapping
	public Topic createTopic(
			@RequestParam("name")String name,
			@RequestParam("description")String description
//			@RequestParam("parentTop")Long parentTop
	                        ){
		return topicService.saveTopic(name,description);
	}
	
}
