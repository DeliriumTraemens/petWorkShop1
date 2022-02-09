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
	
	@GetMapping("/{id}")
	public Topic getTopicById(@PathVariable(name = "id")Long id){
		return topicService.getTopicById(id);
	}
	
	@PostMapping
	public Topic createRootTopic(
			@RequestParam("name")String name,
			@RequestParam("description")String description
	                        ){
		return topicService.saveRootTopic(name, description);
	}
	
	@PostMapping("/newsub")
	public Topic addNewSubTopic(
			@RequestParam("parentId")Long id,
			@RequestParam("name")String name,
	        @RequestParam("description")String description){
		return topicService.addNewSubTopic(id,name,description);
	}
	
}
