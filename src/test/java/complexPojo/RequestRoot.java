package complexPojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class RequestRoot {
	private String Name;
	Request request;
	
	public RequestRoot(String name, Request request) {
		super();
		Name = name;
		this.request = request;
	}

	public RequestRoot() {
		
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Request getRequest() {
		return request;
	}
	public void setRequest(Request request) {
		this.request = request;
	}
	
}
