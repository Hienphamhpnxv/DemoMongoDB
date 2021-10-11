package com.example.demo.servic;

import java.util.List;

import com.example.demo.model.GroceryItem;

public interface ItemServic {

	GroceryItem insert(GroceryItem groceryItem);

	GroceryItem update(GroceryItem groceryItem);

	List<GroceryItem> findByName(String name);

	void delete(String id);

	List<GroceryItem> findAll();

	List<GroceryItem> findAllByCategory(String category);
}
