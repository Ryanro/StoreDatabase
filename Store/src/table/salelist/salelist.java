package table.salelist;

public class salelist {
	private String sale_no;
	private String item_no;
	private String number;
	
	public String getitem_no(){
		return this.item_no;
	}
	
	public String getnumber(){
		return this.number;
	}
	
	public String getsale_no(){
		return this.sale_no;
	}
	
	public void setitem_no(String item_no){
		this.item_no=item_no;
	}
	
	public void setnumber(String number){
		this.number=number;
	}
	public void setsale_no(String sale_no){
		this.sale_no=sale_no;
	}
	
}
