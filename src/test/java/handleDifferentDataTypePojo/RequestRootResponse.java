package handleDifferentDataTypePojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class RequestRootResponse extends RequestRootBase{
	
	RequestResponse request;
	
	public RequestRootResponse(String name, RequestResponse request) {
		super(name);
		this.request = request;
	}

	public RequestRootResponse() {
		
	}
	
	public RequestResponse getRequest() {
		return request;
	}
	public void setRequest(RequestResponse request) {
		this.request = request;
	}
	
}
