package genzmart.repository;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import genzmart.model.Order;

@Repository
public interface NetSalesRepository extends JpaRepository<Order, Long>{
	
	
	@Query(value="select item_class.item_name, sum(orders.price-(orders.price*orders.discount_price/100)) as netsales \r\n" + 
			"from orders inner join item_class on orders.item_id=item_class.item_id\r\n" + 
			"group by item_class.item_id;",nativeQuery=true)
	 public List<JSONObject> itemsNetSales();

}