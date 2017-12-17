package table.attendance;

public class Attendance {
	private String staff_no;
	private String absence_date;
	private String absence_reason;
	

	
	public String getabsence_date(){
		return this.absence_date;
	}
	
	public String getstaff_no(){
		return this.staff_no;
	}
	
	public String getabsence_reason(){
		return this.absence_reason;
	}
	
	
	
	public void setstaff_no(String staff_no){
		this.staff_no=staff_no;
	}
	
	public void setabsence_date(String absence_date){
		this.absence_date=absence_date;
	}
	
	public void setabsence_reason(String absence_reason){
		this.absence_reason=absence_reason;
	}
	
	
	
}
