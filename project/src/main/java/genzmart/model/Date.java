package genzmart.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Date {
	
	@Id
	private String ddate;
	private String month_year;
	private Long month_year_sort;
	private Long year;
	private Long qtr_year;
	private String qtr_year_sort;
	
	public Date() {
		
	}
	
	public String getDdate() {
		return ddate;
	}
	public void setDdate(String ddate) {
		this.ddate = ddate;
	}
	public String getMonth_year() {
		return month_year;
	}
	public void setMonth_year(String month_year) {
		this.month_year = month_year;
	}
	
	public Long getYear() {
		return year;
	}
	public void setYear(Long year) {
		this.year = year;
	}
	
	public Long getMonth_year_sort() {
		return month_year_sort;
	}

	public void setMonth_year_sort(Long month_year_sort) {
		this.month_year_sort = month_year_sort;
	}

	public Long getQtr_year() {
		return qtr_year;
	}

	public void setQtr_year(Long qtr_year) {
		this.qtr_year = qtr_year;
	}

	public String getQtr_year_sort() {
		return qtr_year_sort;
	}
	public void setQtr_year_sort(String qtr_year_sort) {
		this.qtr_year_sort = qtr_year_sort;
	}

	@Override
	public String toString() {
		return "Date [ddate=" + ddate + ", month_year=" + month_year + ", month_year_sort=" + month_year_sort
				+ ", year=" + year + ", qtr_year=" + qtr_year + ", qtr_year_sort=" + qtr_year_sort + "]";
	}
	
	
	

}

