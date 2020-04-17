package genzmart.repository;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import genzmart.model.Order;

@Repository
public interface SalesStatusRepository extends JpaRepository<Order, Long> {
	
	@Query(value="SELECT  o.order_id,o.cogs,o.qty,o.del_date,i.item_name,d.ddate\r\n" + 
			"FROM item i INNER JOIN orders o ON i.item_id=o.item_id\r\n" + 
			"INNER JOIN date d ON d.ddate=o.sal_date where d.year=?2 and d.month_year_sort=?1",nativeQuery= true)
	public List<JSONObject> getMonthYearData(Long month, Long year);

}
