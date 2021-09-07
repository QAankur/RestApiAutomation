package post_Put_delete;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class AutomatePutRequest {

	RequestSpecification request;
	ResponseSpecification response;
	@BeforeClass
	public void beforeClass()
	{
		
		request=given().baseUri("https://api.postman.com").
				header("X-Api-Key", "PMAK-612df644a534b4004766973c-7fd33769eb071b51d08d963f786ac92d19")
				.contentType(ContentType.JSON).log().all();
		
		response=RestAssured.expect().statusCode(200).contentType(ContentType.JSON);
	}
	
	@Test
	public void m1()
	{
		String requestBody="{\r\n"
				+ "\"workspace\":{\r\n"
				+ "\"name\":\"workspace5\",\r\n"
				+ "\"type\":\"personal\",\r\n"
				+ "\"description\":\"This is for testing purpose\"\r\n"
				+ "}\r\n"
				+ "}";
		Response response1=given(request).body(requestBody).
		when().put("/workspaces/44d71269-1f0d-48e4-8c9b-e2bb31d0d1f2").then().
		spec(response).log().all().extract().response();
		System.out.println("Workspace name is : " + JsonPath.from(response1.asString()).getString("workspace.name"));
		System.out.println("Workspace name is : " + JsonPath.from(response1.asString()).getString("workspace.id"));
	}
	
// Using path param in given method
	@Test
	public void m2()
	{
		String param="44d71269-1f0d-48e4-8c9b-e2bb31d0d1f2";
		String requestBody="{\r\n"
				+ "\"workspace\":{\r\n"
				+ "\"name\":\"workspace6\",\r\n"
				+ "\"type\":\"personal\",\r\n"
				+ "\"description\":\"This is for testing purpose\"\r\n"
				+ "}\r\n"
				+ "}";
		Response response1=given(request).body(requestBody).pathParam("param","44d71269-1f0d-48e4-8c9b-e2bb31d0d1f2").
		when().put("/workspaces/{param}").then().
		spec(response).log().all().extract().response();
		System.out.println("Workspace name is : " + JsonPath.from(response1.asString()).getString("workspace.name"));
		System.out.println("Workspace name is : " + JsonPath.from(response1.asString()).getString("workspace.id"));
	}
}
