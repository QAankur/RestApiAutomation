package handleDifferentDataTypePojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class FolderResponse extends FolderBase{

	
	List<RequestRootResponse> item;
	
	public FolderResponse() {
		
	}
	
	public FolderResponse(String name, List<RequestRootResponse> item) {
		super(name);
		this.item = item;
	}

	public List<RequestRootResponse> getItem() {
		return item;
	}
	public void setItem(List<RequestRootResponse> item) {
		this.item = item;
	}
	
	
	
}
