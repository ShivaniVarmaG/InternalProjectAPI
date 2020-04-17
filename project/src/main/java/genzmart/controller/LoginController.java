package genzmart.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import genzmart.services.LoginServices;

@RestController
public class LoginController {

	@Autowired
	private LoginServices loginServices;
	
	@PostMapping(value = "/login")
	public JSONObject login(@RequestBody JSONObject data) {
		return loginServices.login(data);		
	}
	
	@GetMapping(value="/testApi")
	public JSONObject testApi(@RequestHeader(name = "token") String token) {
		if(token!=null && loginServices.validateToken(token)) {
	//		loginServices.someApi();
			return null;		}
		else return null;
	}
	
	
}
