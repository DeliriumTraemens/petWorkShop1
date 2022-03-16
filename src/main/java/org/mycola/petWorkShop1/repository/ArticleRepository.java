package org.mycola.petWorkShop1.repository;

import org.mycola.petWorkShop1.domain.Article;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article,Long> {
	List findAll(Sort sort);
	
}
