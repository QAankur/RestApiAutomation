package requestspecification;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.specification.RequestSpecification;

public class ReUseRequestSpecification {
	
	RequestSpecification requestSpecification;
	
	@BeforeClass
	public void beforeClass()
	{
		requestSpecification=given().
				baseUri("https://api.postman.com").
				header("X-Api-Key", "PMAK-612df644a534b4004766973c-7fd33769eb071b51d08d963f786ac92d19");
	}

	@Test
	public void test1()
	{
		given(requestSpecification).
		when().get("/workspaces").
		then().log().all().assertThat().statusCode(200);
	}
	

	@Test
	public void Test2()
	{
		
		given(requestSpecification).
		when().get("/workspaces").
		then().log().all().assertThat().statusCode(200);
	}
}
