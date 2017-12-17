package table.wage;

public class wage {
	private String staff_no;
	private String absent_num;
	private String wage_date;
	private String pay_wage;

	
	public String getabsent_num(){
		return this.absent_num;
	}
	
	public String getstaff_no(){
		return this.staff_no;
	}
	
	public String getwage_date(){
		return this.wage_date;
	}
	
	public String getpay_wage(){
		return this.pay_wage;
	}
	
	
	
	public void setabsent_num(String absent_num){
		this.absent_num=absent_num;
	}
	
	public void setstaff_no(String staff_no){
		this.staff_no=staff_no;
	}
	
	public void setwage_date(String wage_date){
		this.wage_date=wage_date;
	}
	
	public void setpay_wage(String pay_wage){
		this.pay_wage=pay_wage;
	}
	
	
}
