package table.employee;

public class Employee {
	private String staff_no;
	private String staff_name;
	private String sex;
	private String age;
	private String job;
	private String staff_ps;
	
	public String getStaff_ps(){
		return this.staff_ps;
	}
	
	public String getStaff_no(){
		return this.staff_no;
	}
	
	public String getStaff_name(){
		return this.staff_name;
	}
	
	public String getSex(){
		return this.sex;
	}
	
	public String getAge(){
		return this.age;
	}
	
	public String getJob(){
		return this.job;
	}
	
	public void setStaff_ps(String staff_ps){
		this.staff_ps=staff_ps;
	}
	
	public void setStaff_no(String staff_no){
		this.staff_no=staff_no;
	}
	
	public void setStaff_name(String staff_name){
		this.staff_name=staff_name;
	}
	
	public void setSex(String sex){
		this.sex=sex;
	}
	
	public void setAge(String age){
		this.age=age;
	}
	
	public void setJob(String job){
		this.job=job;
	}
}
