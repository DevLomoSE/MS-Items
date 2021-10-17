package com.devlomose.app.ms.item.models.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.devlomose.app.ms.item.models.Item;
import com.devlomose.app.ms.item.models.Producto;

@Service
public class ItemServiceImplement implements ItemService {
	
	@Autowired
	private RestTemplate clientRest; 

	@Override
	public List<Item> findAll() {
		List<Producto> productos = Arrays.asList(clientRest.getForObject("http://127.0.0.1:8001/productos/listar", Producto[].class));
		return productos.stream().map(product -> new Item(product, 1)).toList();
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		Map<String, String> pathVariables = new HashMap<String, String>();
		pathVariables.put("id", id.toString());
		Producto producto = clientRest.getForObject("http://127.0.0.1:8001/productos/detalle/{id}", Producto.class, pathVariables);
		return new Item(producto, cantidad);
	}

}
