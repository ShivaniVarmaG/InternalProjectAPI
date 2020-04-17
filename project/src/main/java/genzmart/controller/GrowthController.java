package genzmart.controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import genzmart.services.GrowthService;
import genzmart.services.LoginServices;

@RestController
public class GrowthController {
	

	@Autowired
	public GrowthService growthService;
	
	@Autowired
	private LoginServices loginServices;
	
	@GetMapping("/gettingGrowth")
	public List<JSONObject> getGrowthAsMonths(@RequestHeader(name = "token") String token) {
		if (token != null && loginServices.validateToken(token)) {
		return growthService.getGrowthInMonths();
		}else 
			return null;
	}


}
