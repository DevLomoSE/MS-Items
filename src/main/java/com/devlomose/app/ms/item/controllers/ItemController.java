package com.devlomose.app.ms.item.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devlomose.app.ms.item.models.Item;
import com.devlomose.app.ms.item.models.service.ItemService;

@RestController
@RequestMapping("/items")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@GetMapping("/listar")
	public List<Item> listar(){
		return itemService.findAll();
	}
	
	@GetMapping("/detalle/{id}/cantidad/{cantidad}")
	public Item getDetalle(@PathVariable Long id,
							@PathVariable Integer cantidad) {
		return itemService.findById(id, cantidad);
	}

}
