package post_Put_delete;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


public class AutomatePost {

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
				+ "\"name\":\"workspace10\",\r\n"
				+ "\"type\":\"personal\",\r\n"
				+ "\"description\":\"This is for testing purpose\"\r\n"
				+ "}\r\n"
				+ "}";
		Response response1=given(request).body(requestBody).
		when().post("/workspaces").then().
		spec(response).log().all().extract().response();
		System.out.println("Workspace name is : " + JsonPath.from(response1.asString()).getString("workspaces.name"));
	}
}
