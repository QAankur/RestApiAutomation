package handleDifferentDataTypePojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestRootBase {
	private String name;

	public RequestRootBase(String name) {

		this.name = name;
	}

	public RequestRootBase() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		name = name;
	}

}
