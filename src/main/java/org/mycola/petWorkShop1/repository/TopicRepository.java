package org.mycola.petWorkShop1.repository;

import org.mycola.petWorkShop1.domain.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Long> {
}
