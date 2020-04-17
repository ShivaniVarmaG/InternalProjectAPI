package genzmart.repository;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import genzmart.model.Order;

@Repository
public interface ProfitRepository extends JpaRepository<Order, Long>{
	
	 @Query(value = "SELECT item.item_name, sum((orders.cogs-(orders.price-(orders.price*orders.discount/100)))) as profits \r\n" + 
	 		"FROM orders INNER JOIN item ON orders.item_id=item.item_id\r\n" + 
	 		"where (orders.cogs-(orders.price-(orders.price*orders.discount/100)))>0\r\n" + 
	 		"group by item.item_id \r\n" + 
	 		"order by item.item_id; ", nativeQuery = true)
       public List<JSONObject> itemsProfits();

	 
	 
   @Query(value="select geography.city,sum((orders.cogs-(orders.price-(orders.price*orders.discount/100)))) as profit \r\n" + 
   		"from orders  INNER JOIN geography ON orders.city_id=geography.city_id\r\n" + 
   		"where (orders.cogs-(orders.price-(orders.price*orders.discount/100)))>0\r\n" + 
   		"group by geography.city\r\n" + 
   		"order by profit desc;",nativeQuery = true)
   public List<JSONObject> citiesProfits(); 
}
