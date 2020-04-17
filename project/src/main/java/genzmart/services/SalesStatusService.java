package genzmart.services;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import genzmart.repository.SalesStatusRepository;

@Service
public class SalesStatusService {

	@Autowired
	private SalesStatusRepository salesStatus;
	
	public List<JSONObject> displayMonthYearData(Long month, Long year){
		return salesStatus.getMonthYearData(month, year);
	}
	
}
