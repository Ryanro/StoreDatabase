package table.iteminfo;

public class Iteminfo {
	private String item_no;
	private String item_name;
	private String goods_type;
	private String sale_price;
	private String buying_price;
	private String item_ps;
	
	public String getItem_no(){
		return this.item_no;
	}
	
	public String getItem_name(){
		return this.item_name;
	}
	
	public String getGoods_type(){
		return this.goods_type;
	}
	
	public String getSale_price(){
		return this.sale_price;
	}
	
	public String getBuying_price(){
		return this.buying_price;
	}
	
	public String getItem_ps(){
		return this.item_ps;
	}
	
	public void setItem_no(String item_no){
		this.item_no=item_no;
	}
	
	public void setItem_name(String item_name){
		this.item_name=item_name;
	}
	
	public void setGoods_type(String goods_type){
		this.goods_type=goods_type;
	}
	
	public void setSale_price(String sale_price){
		this.sale_price=sale_price;
	}
	
	public void setBuying_price(String buying_price){
		this.buying_price=buying_price;
	}
	
	public void setItem_ps(String item_ps){
		this.item_ps=item_ps;
	}
}
