package genzmart.controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import genzmart.services.LoginServices;
import genzmart.services.NetSalesService;

@RestController
public class NetSalesController {
	
	@Autowired
	public NetSalesService netSalesItem;
	
	@Autowired
	private LoginServices loginServices;
	
	@GetMapping("/netSalesItem")
	public List<JSONObject> getItemsWithNetSasles(@RequestHeader(name = "token") String token) {
		if (token != null && loginServices.validateToken(token)) {
		return netSalesItem.getItemsNetSales();
		}else 
			return null;
	}

}
