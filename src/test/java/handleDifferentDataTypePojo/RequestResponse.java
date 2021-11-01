package handleDifferentDataTypePojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class RequestResponse extends RequestBase {

	URl url;
	
	public RequestResponse()
	{
		
	}
	
	public RequestResponse(URl url, String method, List<Header> header, Body body, String description) {
		super(method,header,body,description);
		this.url=url;
	}
	public URl getUrl() {
		return url;
	}
	public void setUrl(URl url) {
		this.url = url;
	}
	
	
}
