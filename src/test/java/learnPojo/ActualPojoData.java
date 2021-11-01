package learnPojo;

public class ActualPojoData {

	public ActualPojoData()
	{}
	
	private String key1;
	private String key2;
	
	public ActualPojoData(String key1,String key2)
	{
		this.key1=key1;
		this.key2=key2;
	}
	
	public String getkey1()
	{
		
		return key1;
	}
	
	public void setkey1(String key1)
	{
		this.key1=key1;
	}
	
	public String getkey2()
	{
		
		return key2;
	}
	
	public void setkey2(String key2)
	{
		
		this.key2=key2;
	}
}
