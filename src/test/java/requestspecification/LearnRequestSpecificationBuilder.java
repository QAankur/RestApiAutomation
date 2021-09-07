package requestspecification;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LearnRequestSpecificationBuilder {

	RequestSpecification requestSpecification;
	@BeforeClass
	public void beforeClass()
	{
		RequestSpecBuilder builder=new RequestSpecBuilder();
		builder.setBaseUri("https://api.postman.com");
		builder.addHeader("X-Api-Key", "PMAK-612df644a534b4004766973c-7fd33769eb071b51d08d963f786ac92d19");
		builder.log(LogDetail.ALL);
		
		requestSpecification=builder.build();
	}

	@Test
	public void test1()
	{
		given(requestSpecification).
		when().get("/workspaces").
		then().log().all().assertThat().statusCode(200);
	}
	// we can also add other header and information with spec builder
	@Test
	public void test2()
	{
		given(requestSpecification).header("Dummy","Value2").
		when().get("/workspaces").
		then().log().all().assertThat().statusCode(200);
	}
}
