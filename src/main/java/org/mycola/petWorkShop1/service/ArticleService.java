package org.mycola.petWorkShop1.service;

import org.mycola.petWorkShop1.domain.Article;
import org.mycola.petWorkShop1.domain.Topic;
import org.mycola.petWorkShop1.repository.ArticleRepository;
import org.mycola.petWorkShop1.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ArticleService {
	
	private final ArticleRepository artRepo;
	private final TopicRepository topicRepo;
	
	@Autowired
	public ArticleService(ArticleRepository artRepo, TopicRepository topicRepo) {
		this.artRepo = artRepo;
		this.topicRepo = topicRepo;
	}
	
	public List getAllArticles() {
		return artRepo.findAll();
	}
	
	public Article saveNewArticle(Long id, String name, String description) {
		Topic topic = topicRepo.findById(id).get();
		Article newArticle=new Article();
		newArticle.setName(name);
		newArticle.setDescription(description);
		newArticle.setArtTopic(topic);
		newArticle.setCreationDate(LocalDateTime.now());
		
		return artRepo.save(newArticle);
	}
}
