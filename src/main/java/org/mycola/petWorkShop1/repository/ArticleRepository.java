package org.mycola.petWorkShop1.repository;

import org.mycola.petWorkShop1.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article,Long> {
}
