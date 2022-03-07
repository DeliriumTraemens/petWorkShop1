package org.mycola.petWorkShop1.controller;

import org.mycola.petWorkShop1.domain.Item;
import org.mycola.petWorkShop1.domain.Tema;
import org.mycola.petWorkShop1.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/item")
public class ItemController {
	private final ItemService itemService;
	
	@Autowired
	public ItemController(ItemService itemService) {
		this.itemService = itemService;
	}
	
	@GetMapping("/itemsByTema")
	public List<Item> getItemsByTema(@RequestParam("temaId") Long id){
		return itemService.getItemByTema(id);
	}
	
	@GetMapping("/itemId")
	public Item getItemById(@RequestParam("id") Long id){
		return itemService.getItemById(id);
	}
	
	@PostMapping("/addNewitem")
	public List<Tema> addNewitem(@RequestParam("tema")Long id,
	                             @RequestParam("name") String name,
	                             @RequestParam("description") String description,
	                             @RequestParam("file")MultipartFile file){
		return itemService.addNewItem(id, name, description, file);
	}
	
}
