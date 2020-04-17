package genzmart.services;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import genzmart.repository.ItemRepository;

@Service
public class ItemService {
	
	@Autowired
	public ItemRepository order;
	
	
	public List<JSONObject> getItemsWithLessOrders(){
		return order.ItemsWithLessOrders();
}
	
	public List<JSONObject> getItemsWithMoreOrders(){
		return order.ItemsWithMoreOrders();
}
}
