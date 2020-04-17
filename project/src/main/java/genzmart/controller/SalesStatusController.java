package genzmart.controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import genzmart.services.SalesStatusService;

@RestController
public class SalesStatusController {
	
	@Autowired
	private SalesStatusService salesStatus;
	
	@GetMapping(path="/status/{month}/{year}")
	public List<JSONObject> getMonthYear(@RequestParam(value="month",defaultValue="201701")Long month,
			@RequestParam(value="year",defaultValue="2017")Long year){
		return salesStatus.displayMonthYearData(month, year);
	}
}
