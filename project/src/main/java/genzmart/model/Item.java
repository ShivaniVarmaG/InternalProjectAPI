package genzmart.model;

import javax.persistence.Entity;
import javax.persistence.Id;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;

@Entity
public class Item {
	
	@Id
	private Long item_id;
	private String item_name;
	private Long brand_id;
	private Long category_id;
	private Long subcategory_id;
public Long getBrand_id() {
		return brand_id;
	}
	public void setBrand_id(Long brand_id) {
		this.brand_id = brand_id;
	}
	public Long getCategory_id() {
		return category_id;
	}
	public void setCategory_id(Long category_id) {
		this.category_id = category_id;
	}
	public Long getSubcategory_id() {
		return subcategory_id;
	}
	public void setSubcategory_id(Long subcategory_id) {
		this.subcategory_id = subcategory_id;
	}
	//	@ManyToOne
//	private Brand brand_id;
//	@ManyToOne
//	private Category category_id;
//	@ManyToOne
//	private SubCategory subcategory_id;
	public Long getItem_id() {
		return item_id;
	}
	public void setItem_id(Long item_id) {
		this.item_id = item_id;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	
	@Override
	public String toString() {
		return "Item [item_id=" + item_id + ", item_name=" + item_name + ", brand_id=" + brand_id + ", category_id="
				+ category_id + ", subcategory_id=" + subcategory_id + "]";
	}
	
	

}

