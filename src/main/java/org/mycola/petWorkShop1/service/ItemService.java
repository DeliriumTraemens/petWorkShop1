package org.mycola.petWorkShop1.service;

import com.ibm.icu.text.Transliterator;
import org.mycola.petWorkShop1.domain.Item;
import org.mycola.petWorkShop1.domain.Tema;
import org.mycola.petWorkShop1.repository.ItemRepository;
import org.mycola.petWorkShop1.repository.TemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ItemService {
	
	public static final String CYRILLIC_TO_LATIN = "Cyrillic-Latin";
	Transliterator toLatinTrans = Transliterator.getInstance(CYRILLIC_TO_LATIN);
	
	
	@Value("${upload.path}")
	private String uploadPath;
	
	
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
	
	public List<Tema> addNewItem(Long id, String name, String description, MultipartFile file) throws IOException {
		Item newItem = new Item();
		Tema tema = temaRepo.findById(id).get();
		newItem.setName(name);
		newItem.setDescription(description);
		newItem.setTema(tema);
		newItem.setCreationDate(LocalDateTime.now());
		
//		TODO Picture File Processing here
//		String temaName = ПОлучить имя текущей Темы в Стриннг0
//		Добавить его к общему пути  -- String resultPath = uploadPath+temaName
//      File pathMaker = new File(resultPath);
		if(file != null && !file.getOriginalFilename().isEmpty()) {
//          First
			String temaName = toLatinTrans.transliterate(tema.getName()) ;
//			/D:/docs/pics/petworkshop1/pictures/ First
			String resultPathMaker = uploadPath + "/" + temaName;
//			First / bukhlo.jpg
			String resultFileName = temaName +"/"+ file.getOriginalFilename();

			//			Cyrillic Test
			
			
			
			File pathMaker = new File(resultPathMaker);
			if(!pathMaker.exists()) {
				pathMaker.mkdir();
			}
			
			newItem.setImage(resultFileName);
			file.transferTo(new File(uploadPath + "/" + resultFileName));
			
		}
		
		itemRepo.save(newItem);
		
		return temaRepo.findAllByRoot(true);
	}
	
	public Item getItemById(Long id) {
		return itemRepo.findById(id).get();
	}
}
