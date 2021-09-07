package responseSpecification;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class LearnResponseSpecification {

	RequestSpecification requestSpecification;
	ResponseSpecification responseSpecification;
	@BeforeClass
	public void beforeClass()
	{
		RequestSpecBuilder builder=new RequestSpecBuilder();
		builder.setBaseUri("https://api.postman.com");
		builder.addHeader("X-Api-Key", "PMAK-612df644a534b4004766973c-7fd33769eb071b51d08d963f786ac92d19");
		builder.log(LogDetail.ALL);
		
		requestSpecification=builder.build();
		
		responseSpecification=RestAssured.expect().contentType(ContentType.JSON).statusCode(201);
	}

	@Test
	public void test1()
	{
		given(requestSpecification).
		when().get("/workspaces").
		then().spec(responseSpecification).log().all();
	}
	
	@Test
	public void test2()
	{
		given(requestSpecification).
		when().get("/workspaces").
		then().spec(responseSpecification).log().all();
	}
}
