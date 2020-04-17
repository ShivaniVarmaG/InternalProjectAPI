package genzmart.controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import genzmart.services.LoginServices;
import genzmart.services.ProfitService;

@RestController
public class ProfitController {
	
	@Autowired
	public ProfitService profitService;
	
	@Autowired
	private LoginServices loginServices;
	
	@GetMapping("/itemsWithProfits")
	public List<JSONObject> getItemsWithAsProfits(@RequestHeader(name = "token") String token) {
		if (token != null && loginServices.validateToken(token)) {
		return profitService.getItemsWithProfits();
		}else
			return null;
	}

	
	@GetMapping("/citiesWithProfits")
	public List<JSONObject> getCitiesWithProfits(@RequestHeader(name = "token") String token) {
		if (token != null && loginServices.validateToken(token)) {
		return profitService.getCitiesWithProfits();
	} else 
		return null;
}
}
