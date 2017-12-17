package table.information;//具体路径要修改

public class information {
private String sale_no;
private String staff_no;
private String sale_date;


public String getsale_no(){
	return this.sale_no;
}

public void setsale_no(String sale_no){
	this.sale_no=sale_no;
}

public String getstaff_no(){
	return this.staff_no;
}

public void setstaff_no(String staff_no){
	this.staff_no=staff_no;
}

public String getsale_date(){
	return this.sale_date;
}

public void setsale_date(String sale_date){
	this.sale_date=sale_date;
}

}
