package genzmart.services;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import genzmart.repository.GrowthRepository;

@Service
public class GrowthService {
	
	
	@Autowired
	public GrowthRepository growth;
	
	public List<JSONObject> getGrowthInMonths(){
		return growth.growthInMonths();
}

}
