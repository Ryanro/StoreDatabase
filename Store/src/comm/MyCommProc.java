package comm;

//字符转换

public class MyCommProc {

	public String getString(String s)
	{
		if(s==null){
			s="";
		}
		try
		{
			byte b[]=s.getBytes("ISO-8859-1");
			s=new String(b);
		}
		catch(Exception b){}
		return s;
	}
	
}
