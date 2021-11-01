package handleDifferentDataTypePojo;

import java.util.List;



public class CollectionRequest extends CollectionBase {

	List<FolderRequest> item;

	public CollectionRequest( Info info, List<FolderRequest> item) {
		super(info);
		this.item = item;
	}
	public CollectionRequest() {
	}

	


	public List<FolderRequest> getItem() {
		return item;
	}

	public void setItem(List<FolderRequest> item) {
		this.item = item;
	}

}
