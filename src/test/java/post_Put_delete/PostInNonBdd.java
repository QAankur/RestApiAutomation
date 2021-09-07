package post_Put_delete;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class PostInNonBdd {

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
				+ "\"name\":\"workspace4\",\r\n"
				+ "\"type\":\"personal\",\r\n"
				+ "\"description\":\"This is for testing purpose\"\r\n"
				+ "}\r\n"
				+ "}";
		Response response=given(request).body(requestBody).post("/workspaces");
		System.out.println(JsonPath.from(response.asString()).getString("workspace.name"));
		//Assert.assertEquals(response.path("workspaces.name"), "workspace4");
	}
}
