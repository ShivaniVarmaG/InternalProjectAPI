package genzmart.services;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import genzmart.repository.ProfitRepository;

@Service
public class ProfitService {
	
	@Autowired
	public ProfitRepository profit;
	
	public List<JSONObject> getItemsWithProfits(){
		return profit.itemsProfits();
}
	
	public List<JSONObject> getCitiesWithProfits(){
		return profit.citiesProfits();
}
}
