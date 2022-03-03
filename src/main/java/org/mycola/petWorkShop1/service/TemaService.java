package org.mycola.petWorkShop1.service;

import org.mycola.petWorkShop1.domain.Tema;
import org.mycola.petWorkShop1.repository.TemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TemaService {
	private final TemaRepository temaRepo;
	
	@Autowired
	public TemaService(TemaRepository temaRepo) {
		this.temaRepo = temaRepo;
	}
	
	public List <Tema> findAllByRoot() {
		return temaRepo.findAllByRoot(true);
	}
	
	public List<Tema> createNewTema(String name, String description) {
		
		Tema rootTema=temaRepo.findByRoot(true);
		Tema newTema=new Tema();
		if(!name.equals("")){
			newTema.setName(name);
			newTema.setDescription(description);
			newTema.setCreationDate(LocalDateTime.now());
			newTema.setParentTema(rootTema);
		}
		
		
		temaRepo.save(newTema);
		return findAllByRoot();
		
	}
	
	public List<Tema> createSubTema(Long idParent, String name, String description) {
		Tema parent= temaRepo.findById(idParent).get();
		Tema newSub= new Tema();
		if(!name.equals("")){
			newSub.setName(name);
			newSub.setDescription(description);
			newSub.setParentTema(parent);
			newSub.setCreationDate(LocalDateTime.now());
			
			temaRepo.save(newSub);
		} else {
			return findAllByRoot();
		}
		return findAllByRoot();
	}
}
