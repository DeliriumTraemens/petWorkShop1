package org.mycola.petWorkShop1.repository;

import org.mycola.petWorkShop1.domain.Tema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TemaRepository extends JpaRepository<Tema, Long> {
	List<Tema> findAllByRoot(boolean b);
}
