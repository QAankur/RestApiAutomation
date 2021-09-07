package responseSpecification;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class LearnResponseSpecBuilder {

	ResponseSpecification responseSpecification;
	RequestSpecification requestSpecification;
	@BeforeClass
	public void beforeClass()
	{
		RequestSpecBuilder requestbuilder=new RequestSpecBuilder();
		requestbuilder.setBaseUri("https://api.postman.com");
		requestbuilder.addHeader("X-Api-Key", "PMAK-612df644a534b4004766973c-7fd33769eb071b51d08d963f786ac92d19");
		requestbuilder.log(LogDetail.ALL);
		
		requestSpecification=requestbuilder.build();
		
		ResponseSpecBuilder responsebuilder=new ResponseSpecBuilder();
		responsebuilder.expectStatusCode(200);
		responsebuilder.expectContentType(ContentType.JSON);
		responseSpecification=responsebuilder.build();
	}

	@Test
	public void test1()
	{
		given(requestSpecification).
		when().get("/workspaces").
		then().spec(responseSpecification).log().all();
	}
}
