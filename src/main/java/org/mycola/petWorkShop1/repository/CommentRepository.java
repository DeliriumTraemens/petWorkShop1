package org.mycola.petWorkShop1.repository;

import org.mycola.petWorkShop1.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
