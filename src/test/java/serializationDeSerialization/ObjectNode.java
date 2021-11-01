package serializationDeSerialization;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class ObjectNode {

	RequestSpecification request;
	ResponseSpecification response;

	@BeforeClass
	public void beforeClass() {

		request = given().baseUri("https://api.postman.com")
				.header("X-Api-Key", "PMAK-612df644a534b4004766973c-7fd33769eb071b51d08d963f786ac92d19")
				.contentType(ContentType.JSON).log().all();

		response = RestAssured.expect().statusCode(200).contentType(ContentType.JSON);
	}

	@Test
	public void m1() throws JsonProcessingException {

		ObjectMapper mapper = new ObjectMapper();
		com.fasterxml.jackson.databind.node.ObjectNode parentNode = mapper.createObjectNode();

		com.fasterxml.jackson.databind.node.ObjectNode nestedObject = mapper.createObjectNode();
		nestedObject.put("name", "workspace22");
		nestedObject.put("type", "personal");
		nestedObject.put("description", "This is for testing purpose");
		parentNode.put("workspace", nestedObject);

		String str=mapper.writeValueAsString(parentNode);
		Response response1 = given(request).body(str).when().post("/workspaces").then().spec(response).log().all()
				.extract().response();
		System.out.println("Workspace name is : " + JsonPath.from(response1.asString()).getString("workspaces.name"));
	}
}
