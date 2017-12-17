package bean;

import java.io.UnsupportedEncodingException;

public class Trans {
public String change(String str){
	try{
		str=new String(str.getBytes("iso-8859-1"),"utf-8");
		
	}catch(UnsupportedEncodingException e){
		e.printStackTrace();
	}
	return str;
}
}
