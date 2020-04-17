package genzmart.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SubCategory {

	@Id
	private Long subCategoryId;
	private String subCategory;
	public Long getSubCategoryId() {
		return subCategoryId;
	}
	public void setSubCategoryId(Long subCategoryId) {
		this.subCategoryId = subCategoryId;
	}
	public String getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}
	@Override
	public String toString() {
		return "SubCategory [subCategoryId=" + subCategoryId + ", subCategory=" + subCategory + "]";
	}
	
	
}
