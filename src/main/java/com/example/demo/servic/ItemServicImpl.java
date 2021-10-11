package com.example.demo.servic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.model.GroceryItem;
import com.example.demo.repo.ItemRepository;

@Service
public class ItemServicImpl implements ItemServic {

	@Autowired
	ItemRepository itemRepository;

	@Override
	public GroceryItem insert(GroceryItem groceryItem) {
		// TODO Auto-generated method stub
		return itemRepository.insert(groceryItem);
	}

	@Override
	public List<GroceryItem> findByName(String name) {
		// TODO Auto-generated method stub
		return itemRepository.findItemByName(name);
	}

	@Override
	public GroceryItem update(GroceryItem groceryItem) {
		GroceryItem item = itemRepository.findById(groceryItem.getId()).orElseThrow(() -> {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		});
		item.setCategory(groceryItem.getCategory());
		item.setName(groceryItem.getName());
		item.setQuantity(groceryItem.getQuantity());
		return itemRepository.save(item);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		itemRepository.delete(itemRepository.findById(id).orElseThrow(() -> {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}));
	}

	@Override
	public List<GroceryItem> findAll() {
		// TODO Auto-generated method stub
		return itemRepository.findAll();
	}

	@Override
	public List<GroceryItem> findAllByCategory(String category) {
		// TODO Auto-generated method stub
		return itemRepository.findByCategory(category);
	}

}
