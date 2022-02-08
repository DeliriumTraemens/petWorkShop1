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
	public List getAllArticles(){
		return artService.getAllArticles();
	}
	
	@PostMapping
	public Article createNewArticle(@RequestParam(name = "id")Long id,
	                                @RequestParam(name = "name")String name,
	                                @RequestParam(name = "text")String description){
		return artService.saveNewArticle(id,name,description);
	}
	
}
