package com.example.demo.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.demo.model.GroceryItem;

public interface ItemRepository extends MongoRepository<GroceryItem,String>{

	@Query("{name:{ $regex: '?0'}}")
	public List<GroceryItem> findItemByName(String name);
	
	@Query("{category : '?0'}")
	public List<GroceryItem> findByCategory(String category);
	
	public long count();
}
