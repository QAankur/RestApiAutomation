package learnPojo;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_DEFAULT.NON_NULL)
public class Workspace {

	private String name;
	private String type;
	private String description;
	private String id;
	
	public Workspace()
	{
		
	}
	public Workspace(String name, String type, String description)
	{
		this.name=name;
		this.type=type;
		this.description=description;
	}
	
	
	
	public String getName()
	{
		return name;
	}
	
	public String getType()
	{
		return type;
	}
	
	public String getDesc()
	{
		return description;
	}
	
	public String getId()
	{
		return id;
	}
	
	public void setId(String id)
	{
		this.id=id;
	}
	
	public void setName(String name)
	{
		this.name=name;
	}
	
	public void setType(String type)
	{
		this.type=type;
	}
	
	public void  setDesc(String description)
	{
		this.description=description;
	}
}
