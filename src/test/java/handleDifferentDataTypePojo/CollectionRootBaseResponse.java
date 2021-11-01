package handleDifferentDataTypePojo;



public class CollectionRootBaseResponse extends CollectionRootBase{

	CollectionResponse collection;

	public CollectionRootBaseResponse(CollectionResponse collection) {

		this.collection = collection;
	}

	public CollectionRootBaseResponse() {

	}

	public CollectionResponse getCollection() {
		return collection;
	}

	public void setCollection(CollectionResponse collection) {
		this.collection = collection;
	}

}
