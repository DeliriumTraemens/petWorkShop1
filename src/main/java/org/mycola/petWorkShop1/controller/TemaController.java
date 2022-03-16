package org.mycola.petWorkShop1.controller;

import org.mycola.petWorkShop1.domain.Tema;
import org.mycola.petWorkShop1.repository.TemaRepository;
import org.mycola.petWorkShop1.service.TemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
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
	
	@GetMapping("/{id}")
	public Optional<Tema> getTemaById(@PathVariable (value = "id") Long id){
		return temaService.getTemaById(id);
	}
	
	
//	@PostMapping("/createRoot")
//	public void createRootTema(){
//		Tema newRottema = new Tema();
//		newRottema.setName("Root");
//		newRottema.setDescription("Root");
//		newRottema.setRoot(true);
//		newRottema.setCreationDate(LocalDateTime.now());
//
//		temaRepo.save(newRottema);
//	}
	
	@PostMapping
	public List<Tema> createNewTema(@RequestParam("name")String name,
	                                @RequestParam("description")String description) {
		return temaService.createNewTema(name,description);
	}
	
	@PostMapping("/newSubTema")
	public List<Tema> createNewSubTema(
			@RequestParam("idParent")Long idParent,
			@RequestParam("name")String name,
	        @RequestParam("description")String description){
		return temaService.createSubTema(idParent, name, description);
	}
	
	@PostMapping("/dragedit")
	public List <Tema> dragedit(@RequestParam ("id") Long id,
	                            @RequestParam ("parentTema") Long parentTema){
		return temaService.editDragged(id, parentTema);
	}
	
	
}
