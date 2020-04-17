package genzmart.repository;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import genzmart.model.Order;

@Repository
public interface DiscountRepository extends JpaRepository<Order, Long> {

	@Query(value="select discount from orders where item_id=?1",nativeQuery= true)
	public List<Long> getDiscount(Long item_id);
	
	@Query(value="select count(discount) from orders where item_id=?1 and discount=?2",nativeQuery= true)
	public Long getDiscountForItem(Long item_id,Long discount);
	
//	@Query(value="select item_id,count(discount) from orders where item_id=?1 and discount=?2 GROUP BY item_id",nativeQuery= true)
//	public JSONObject getDiscountForItems1(Long item_id,Long discount);
	
	@Query(value="select discount,count(discount) from orders where item_id=?1 GROUP BY item_id,discount",nativeQuery= true)
	public List<JSONObject> getDiscountForItems(Long item_id);
}
