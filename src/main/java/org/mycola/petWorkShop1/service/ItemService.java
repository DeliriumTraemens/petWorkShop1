package org.mycola.petWorkShop1.service;

import org.mycola.petWorkShop1.domain.Item;
import org.mycola.petWorkShop1.domain.Tema;
import org.mycola.petWorkShop1.repository.ItemRepository;
import org.mycola.petWorkShop1.repository.TemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class ItemService {
	
	private final ItemRepository itemRepo;
	private final TemaRepository temaRepo;
	@Autowired
	public ItemService(ItemRepository itemRepo, TemaRepository temaRepo) {
		this.itemRepo = itemRepo;
		this.temaRepo = temaRepo;
	}
	
	public List<Item> getItemByTema(Long id) {
		return itemRepo.getItemByTema(id);
	}
	
	public List<Tema> addNewItem(Long id, String name, String description, MultipartFile file) {
		Item newItem = new Item();
		Tema tema = temaRepo.findById(id).get();
		newItem.setName(name);
		newItem.setDescription(description);
		newItem.setTema(tema);
		
//		TODO Picture File Processing here
//		String temaName = ПОлучить имя текущей Темы в Стриннг0
//		Добавить его к общему пути  -- String resultPath = uploadPath+temaName
//      File pathMaker = new File(resultPath);
		
		
		
		
		return temaRepo.findAllByRoot(true);
	}
	
	public Item getItemById(Long id) {
		return itemRepo.findById(id).get();
	}
}
