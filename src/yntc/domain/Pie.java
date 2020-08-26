package yntc.domain;

public class Pie {
	private String type;
	private int Sum;
	
	public Pie() {
		super();
	}
	public Pie(String type, int Sum) {
		super();
		this.type = type;
		this.Sum = Sum;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getSum() {
		return Sum;
	}
	public void setSum(int sum) {
		Sum = sum;
	}
	
	
}
