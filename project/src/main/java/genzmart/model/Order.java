package genzmart.model;

import javax.persistence.Entity;
import javax.persistence.Id;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="orders") 
public class Order {
	@Id
	private Long order_id;
	private Long item_id;
	private String sal_date;
	private Long cus_id;
	//@ManyToOne
//	private Item item_id;
//	//@ManyToOne
//	private Date sal_date;
//	//@ManyToOne
//	private Customer cus_id;
	//@ManyToOne
//	private Geography city_id;
	private Long city_id;
	private Long qty;
	private Long price;
	private Long cogs;
	private Long discount;
	private String del_date;
	

	public Long getCity_id() {
		return city_id;
	}

	public void setCity_id(Long city_id) {
		this.city_id = city_id;
	}

	public Long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}

//	public Item getItem_id() {
//		return item_id;
//	}
//
//	public void setItem_id(Item item_id) {
//		this.item_id = item_id;
//	}
//
//	public Date getSal_date() {
//		return sal_date;
//	}
//
//	public void setSal_date(Date sal_date) {
//		this.sal_date = sal_date;
//	}
//
//	public Customer getCus_id() {
//		return cus_id;
//	}
//
//	public void setCus_id(Customer cus_id) {
//		this.cus_id = cus_id;
//	}

//	public Geography getCity_id() {
//		return city_id;
//	}
//
//	public void setCity_id(Geography city_id) {
//		this.city_id = city_id;
//	}

	public Long getQty() {
		return qty;
	}

	public Long getItem_id() {
		return item_id;
	}

	public void setItem_id(Long item_id) {
		this.item_id = item_id;
	}

	public String getSal_date() {
		return sal_date;
	}

	public void setSal_date(String sal_date) {
		this.sal_date = sal_date;
	}

	public Long getCus_id() {
		return cus_id;
	}

	public void setCus_id(Long cus_id) {
		this.cus_id = cus_id;
	}

	public void setQty(Long qty) {
		this.qty = qty;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Long getCogs() {
		return cogs;
	}

	public void setCogs(Long cogs) {
		this.cogs = cogs;
	}

	public Long getDiscount() {
		return discount;
	}

	public void setDiscount(Long discount) {
		this.discount = discount;
	}

	public String getDel_date() {
		return del_date;
	}

	public void setDel_date(String del_date) {
		this.del_date = del_date;
	}

	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", item_id=" + item_id + ", sal_date=" + sal_date + ", cus_id=" + cus_id
				+ ", city_id=" + city_id + ", qty=" + qty + ", price=" + price + ", cogs=" + cogs + ", discount="
				+ discount + ", del_date=" + del_date + "]";
	}
	
}

