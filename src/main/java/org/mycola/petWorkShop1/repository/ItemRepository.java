package org.mycola.petWorkShop1.repository;

import org.mycola.petWorkShop1.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
	List<Item> getItemByTema(Long id);
}
