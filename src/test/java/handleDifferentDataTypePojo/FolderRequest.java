package handleDifferentDataTypePojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class FolderRequest extends FolderBase{

	List<RequestRootRequest> item;
	
	public FolderRequest() {
		
	}
	
	public FolderRequest(String name, List<RequestRootRequest> item) {
		super(name);
		this.item = item;
	}

	public List<RequestRootRequest> getItem() {
		return item;
	}
	public void setItem(List<RequestRootRequest> item) {
		this.item = item;
	}
	
	
	
}
