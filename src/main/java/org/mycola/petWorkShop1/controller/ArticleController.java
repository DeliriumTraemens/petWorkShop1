package org.mycola.petWorkShop1.controller;

import org.mycola.petWorkShop1.domain.Article;
import org.mycola.petWorkShop1.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/article")
public class ArticleController {
	
	private final ArticleService artService;
	
	@Autowired
	public ArticleController(ArticleService artService) {
		this.artService = artService;
	}
	
	@GetMapping
	public List getAllArticles() {
		return artService.getAllArticles();
	}
	
	@PostMapping
	public Article createNewArticle(
			@RequestParam(name = "id") Long id,
			@RequestParam(name = "name") String name,
			@RequestParam(name = "description") String description
	                               ) {
		return artService.saveNewArticle(id, name, description);
	}
	
	@PostMapping("/edit")
	public Article editArticles(
			@RequestParam(name = "id") Long id,
			@RequestParam(name = "artTopic") String artTopic,
			@RequestParam(name = "name") String name,
			@RequestParam(name = "description") String description) {
		return artService.editArticle(id, artTopic, name, description);
	}
	
}
