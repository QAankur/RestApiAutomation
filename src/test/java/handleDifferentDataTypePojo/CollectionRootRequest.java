package handleDifferentDataTypePojo;



public class CollectionRootRequest extends CollectionRootBase {

	CollectionRequest collection;

	public CollectionRootRequest(CollectionRequest collection) {

		this.collection = collection;
	}

	public CollectionRootRequest() {

	}

	public CollectionRequest getCollection() {
		return collection;
	}

	public void setCollection(CollectionRequest collection) {
		this.collection = collection;
	}

}
