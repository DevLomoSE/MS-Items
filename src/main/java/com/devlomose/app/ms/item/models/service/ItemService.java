package com.devlomose.app.ms.item.models.service;

import java.util.List;

import com.devlomose.app.ms.item.models.Item;

public interface ItemService {
	
	public List<Item> findAll();
	public Item findById(Long id, Integer cantidad);

}
