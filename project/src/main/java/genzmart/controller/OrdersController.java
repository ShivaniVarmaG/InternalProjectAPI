package genzmart.controller;

import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import genzmart.model.Order;
import genzmart.services.LoginServices;
import genzmart.services.OrdersService;

@RestController
@ResponseBody
@CrossOrigin(origins="*")
public class OrdersController {

	private OrdersService ordersService;
	
	@Autowired
	private LoginServices loginServices;
	
	@Autowired
	public OrdersController(OrdersService ordersService) {
		this.ordersService=ordersService;
	}
	
	@GetMapping("/status")
	public List<JSONObject> getAllOrders() {
		return ordersService.getAllOrdersList();
	}
	
	@GetMapping("/{cityid}")
	public List<Order> getOrdersInCity(@PathVariable (value="cityid") Long city_id){
//		Long count = ordersService.getOrdersInCityList(city);
//		HashMap<Long,Long> h = new HashMap<Long, Long>();
//		h.put(city_id, count);
		return ordersService.getOrdersInCityList(city_id);
	}
	@GetMapping("/api/{cityid}")
	public HashMap<Long,Long>  getCountOrdersInCity(@PathVariable (value="cityid") Long city_id){
		Long count = ordersService.getCountOrdersInCity(city_id);
		HashMap<Long,Long> h = new HashMap<Long, Long>();
		h.put(city_id, count);
		return h;
	}
	
	@GetMapping("/geography")
	public HashMap<String,Long> getCityIdAndCityName(){
		HashMap<String,Long> totalCitiesWithCount = new HashMap<String, Long>();
		List noOfCities =  ordersService.getCityIdAndCityName();
		for (int i = 0; i < noOfCities.size(); i++) {
			Long count = ordersService.getCountOrdersInCity((long) (i+1));
			totalCitiesWithCount.put((String) noOfCities.get(i), count);
		}
		return totalCitiesWithCount; 
	}
	
	@GetMapping("/api/citiesWithLessOrders")
	public List<JSONObject> getcitiesWithLessOrders() {
		return ordersService.getCitiesWithLessOrders();
	}
	
	@GetMapping("/api/citiesWithMoreOrders")
	public List<JSONObject> getcitiesWithMoreOrders() {
		return ordersService.getCitiesWithMoreOrders();
	}
	
	@GetMapping("/trends/itemsInTrending")
	public List<JSONObject> getTrendingItems(@RequestHeader(name = "token") String token) {
		if (token != null && loginServices.validateToken(token)) {
		return ordersService.getItemsWhichAreTrending();
	}else 
		return null;
	}
	
	@GetMapping("/trends/itemsInTrendingInCities")
	public List<JSONObject> getTrendingItemsCities(@RequestHeader(name = "token") String token) {
		if (token != null && loginServices.validateToken(token)) {
		return ordersService.getItemsWhichAreTrendingInCities();
	}else
		return null;
	}
	
	@GetMapping("/trends/{city}")
	public List<JSONObject> getParticularCityTrendingItem(@PathVariable (value="city") String city,@RequestHeader(name = "token") String token){
		if (token != null && loginServices.validateToken(token)) {
		return ordersService.getItemsWhichAreTrendingInParticularCities(city);
	}else
		return null;
		}
}

