package requestspecification;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.SpecificationQuerier;

public class LearnQueryReqSpec {

	@BeforeClass
	public void beforeClass()
	{
		RequestSpecBuilder builder=new RequestSpecBuilder();
		builder.setBaseUri("https://api.postman.com");
		builder.addHeader("X-Api-Key", "PMAK-612df644a534b4004766973c-7fd33769eb071b51d08d963f786ac92d19");
		builder.log(LogDetail.ALL);
		
		RestAssured.requestSpecification=builder.build();
	}

	@Test
	public void test1()
	{
		QueryableRequestSpecification query=SpecificationQuerier.query(RestAssured.requestSpecification);
		System.out.println(query.getHeaders());
		
	}
}
