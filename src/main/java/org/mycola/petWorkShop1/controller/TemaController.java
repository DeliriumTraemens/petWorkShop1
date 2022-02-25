package org.mycola.petWorkShop1.controller;

import org.mycola.petWorkShop1.domain.Tema;
import org.mycola.petWorkShop1.repository.TemaRepository;
import org.mycola.petWorkShop1.service.TemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tema")
public class TemaController {
	private final TemaRepository temaRepo;
	private final TemaService temaService;
	
	@Autowired
	public TemaController(TemaRepository temaRepo, TemaService temaService) {
		this.temaRepo = temaRepo;
		this.temaService = temaService;
	}
	
	@GetMapping
	public List <Tema> getAll(){
		return temaService.findAllByRoot();
	}
	
	@PostMapping
	public List<Tema> createNewTema(@RequestParam("name")String name,
	                                @RequestParam("description")String description,
	                                @RequestParam("root")int root){
		return temaService.createNewTema(name,description,root);
	}
}
