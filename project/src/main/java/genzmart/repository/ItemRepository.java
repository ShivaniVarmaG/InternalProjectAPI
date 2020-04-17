package genzmart.repository;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import genzmart.model.Order;

@Repository
public interface ItemRepository extends JpaRepository<Order, Long> {
	
	
	 @Query(value = "SELECT item.item_name,count(orders.order_id),sum(orders.qty)\r\n" + 
	 		        "FROM orders INNER JOIN item ON orders.item_id=item.item_id \r\n" + 
	 		        "group by item.item_name order by count(orders.order_id) asc; ", nativeQuery = true)
	     public List<JSONObject> ItemsWithLessOrders();

	 @Query(value = "SELECT item.item_name,count(orders.order_id),sum(orders.qty)\r\n" + 
		        "FROM orders INNER JOIN item ON orders.item_id=item.item_id \r\n" + 
		        "group by item.item_name order by count(orders.order_id) desc; ", nativeQuery = true)
     public List<JSONObject> ItemsWithMoreOrders();
	 
}
