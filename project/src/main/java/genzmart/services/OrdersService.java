package genzmart.services;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import genzmart.model.Order;
import genzmart.repository.GeographyRepository;
import genzmart.repository.OrdersRepository;

@Service
public class OrdersService {
	
	
	private OrdersRepository ordersRepository;
	private GeographyRepository geographyRepository;
	@Autowired
	public OrdersService(OrdersRepository ordersRepository,GeographyRepository geographyRepository) {
		this.ordersRepository=ordersRepository;
		this.geographyRepository=geographyRepository;
	}
	public List<JSONObject> getAllOrdersList(){
		return ordersRepository.getAllOrders();
	}
	public List<Order> getOrdersInCityList(Long city_id) {
		// TODO Auto-generated method stub
		return ordersRepository.findByGeographyCity_id(city_id);
	}
	
	public Long getCountOrdersInCity(Long city_id) {
		return ordersRepository.findByGeographyCity_idCount(city_id);
		
	}
	
	public List getCityIdAndCityName() {
		return geographyRepository.findAllByCity();	
	}
	
	public List<JSONObject> getCitiesWithLessOrders(){
		return ordersRepository.findWhichCitiesHaveLessOrders();
	}
	
	public List<JSONObject> getCitiesWithMoreOrders(){
		return ordersRepository.findWhichCitiesHaveMoreOrders();
	}
	
	public List<JSONObject> getItemsWhichAreTrending(){
		return ordersRepository.findItemWhichAreTrending();
	}
	
	public List<JSONObject> getItemsWhichAreTrendingInCities(){
		return ordersRepository.findItemWhichAreTrendingInCities();
	}
	
	public List<JSONObject> getItemsWhichAreTrendingInParticularCities(String cityName){
		return ordersRepository.findItemWhichAreTrendingInParticularCities(cityName);
	}
}

