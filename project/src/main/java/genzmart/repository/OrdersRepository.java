package genzmart.repository;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import genzmart.model.Order;

@Repository
public interface OrdersRepository extends JpaRepository<Order, Long> {

	
	@Query(value = "SELECT * FROM orders WHERE city_id = ?1", nativeQuery = true)
	public List<Order> findByGeographyCity_id(Long city_id);
	
	
	@Query(value = "SELECT count(*) FROM orders WHERE city_id = ?1", nativeQuery = true)
	public Long findByGeographyCity_idCount(Long city_id);
	
	@Query(value = "SELECT  geography.city,count(orders.order_id)\r\n" + 
			"FROM orders INNER JOIN geography ON orders.city_id=geography.city_id\r\n" + 
			"group by geography.city order by count(orders.order_id) asc limit 10;", nativeQuery = true)
	public List<JSONObject> findWhichCitiesHaveLessOrders();
	
	@Query(value = "SELECT  geography.city,count(orders.order_id)\r\n" + 
			"FROM orders INNER JOIN geography ON orders.city_id=geography.city_id\r\n" + 
			"group by geography.city order by count(orders.order_id) desc limit 10;", nativeQuery = true)
	public List<JSONObject> findWhichCitiesHaveMoreOrders();
	
	@Query(value="SELECT  item.item_name,count(orders.order_id)\r\n" + 
			"FROM item INNER JOIN orders ON item.item_id=orders.item_id\r\n" + 
			"group by item.item_name order by count(orders.order_id) desc;",nativeQuery = true)
	public List<JSONObject> findItemWhichAreTrending();
	
	@Query(value="SELECT  geography.city,item.item_name,count(orders.order_id)\r\n" + 
			"FROM item CROSS JOIN geography\r\n" + 
			"INNER JOIN orders ON item.item_id=orders.item_id\r\n" + 
			"where geography.city_id=orders.city_id\r\n" + 
			"group by item.item_name,geography.city order by geography.city,count(orders.order_id) desc;\r\n" + 
			"",nativeQuery=true)
	public List<JSONObject> findItemWhichAreTrendingInCities();
	
	
	@Query(value="SELECT  item.item_name,count(orders.order_id)\r\n" + 
			"FROM item INNER JOIN orders ON item.item_id=orders.item_id\r\n" + 
			"INNER JOIN geography on orders.city_id=geography.city_id\r\n" + 
			"where geography.city=?1 \r\n" + 
			"group by item.item_name order by count(orders.order_id) desc;",nativeQuery=true)
	public List<JSONObject> findItemWhichAreTrendingInParticularCities(String cityName);
	
	@Query(value="SELECT  o.order_id,o.cogs,o.qty,o.del_date,i.item_name,d.ddate\r\n" + 
			"FROM item i INNER JOIN orders o ON i.item_id=o.item_id\r\n" + 
			"INNER JOIN date d ON d.ddate=o.sal_date\r\n" + 
			"",nativeQuery=true)
	public List<JSONObject> getAllOrders();
}

