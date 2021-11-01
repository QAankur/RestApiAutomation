package complexPojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class CollectionRoot {
	Collection collection;

	public CollectionRoot(Collection collection) {

		this.collection = collection;
	}

	public CollectionRoot() {

	}

	public Collection getCollection() {
		return collection;
	}

	public void setCollection(Collection collection) {
		this.collection = collection;
	}

}
