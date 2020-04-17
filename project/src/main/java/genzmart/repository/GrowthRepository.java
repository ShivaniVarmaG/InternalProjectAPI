package genzmart.repository;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import genzmart.model.Order;

@Repository
public interface GrowthRepository extends JpaRepository<Order, Long>{
	
	@Query(value="select date.month_year,count(orders.order_id)\r\n" + 
			"from orders inner join date on orders.sal_date=date.ddate\r\n" + 
			"group by date.month_year\r\n" + 
			"order by date.month_year;", nativeQuery=true)
	 public List<JSONObject> growthInMonths();
	

}
