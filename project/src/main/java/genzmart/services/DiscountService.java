package genzmart.services;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import genzmart.model.Order;
import genzmart.repository.DiscountRepository;

@Service
public class DiscountService {
	
	@Autowired
	public DiscountRepository order;
	
	public List<Long> disData(Long item_id){
		return order.getDiscount(item_id);
	}
	
	public Long disDataForItem(Long item_id,Long discount){
		return order.getDiscountForItem(item_id,discount);
	}
	
	public List<JSONObject> disDataForItems(Long item_id){
		return order.getDiscountForItems(item_id);
	}

	
	

}
