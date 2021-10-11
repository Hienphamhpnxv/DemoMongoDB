package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.GroceryItem;
import com.example.demo.servic.ItemServic;

@RestController
public class GroceryController {

	@Autowired
	ItemServic itemServic;
	
	@GetMapping("/search")
	public ResponseEntity<List<GroceryItem>> getGroceryByName(@RequestParam("name") String name){
		return ResponseEntity.ok(itemServic.findByName(name));
	}
	
	@GetMapping("/category/{categoryName}")
	public ResponseEntity<List<GroceryItem>> getGroceryByCategory(@PathVariable("categoryName") String category){
		return ResponseEntity.ok(itemServic.findAllByCategory(category));
	}
	
	@GetMapping
	public ResponseEntity<List<GroceryItem>> getAllGrocery(){
		return ResponseEntity.ok(itemServic.findAll());
	}
	
	@PostMapping
	public ResponseEntity<GroceryItem> insertGrocery(@RequestBody GroceryItem groceryItem){
		return ResponseEntity.ok(itemServic.insert(groceryItem));
	}
	
	@PutMapping
	public ResponseEntity<GroceryItem> updateGrocery(@RequestBody GroceryItem groceryItem){
		return ResponseEntity.ok(itemServic.update(groceryItem));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteGrocery(@PathVariable String id){
		itemServic.delete(id);
		return ResponseEntity.ok("ok");
	}
}
