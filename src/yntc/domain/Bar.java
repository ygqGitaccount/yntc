package yntc.domain;

public class Bar {
	private String year;
	  private String month;
	  private String location;
	  private int countNumber;
	public Bar(String year, String month, String location, int countNumber) {
		super();
		this.year = year;
		this.month = month;
		this.location = location;
		this.countNumber = countNumber;
	}
	public Bar() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getCountNumber() {
		return countNumber;
	}
	public void setCountNumber(int countNumber) {
		this.countNumber = countNumber;
	}
	@Override
	public String toString() {
		return "Bar [year=" + year + ", month=" + month + ", location=" + location + ", countNumber=" + countNumber
				+ "]";
	}
	  
	  
}
