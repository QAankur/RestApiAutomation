package requestspecification;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BddToNonBdd {

RequestSpecification requestSpecification;
	
	@BeforeClass
	public void beforeClass()
	{
		requestSpecification=given().
				baseUri("https://api.postman.com").
				header("X-Api-Key", "PMAK-612df644a534b4004766973c-7fd33769eb071b51d08d963f786ac92d19").log().all();
		/* log().all(). will log the request , not the response */
	}

	@Test
	public void test1()
	{
		//Extracting response 
		Response response=requestSpecification.get("/workspaces").then().log().all().extract().response();
		System.out.println(response.getStatusCode());
		
		//then().log().all().assertThat().statusCode(200);
	}
	

	@Test
	public void Test2()
	{
		
		given(requestSpecification).
		when().get("/workspaces").
		then().log().all().assertThat().statusCode(200);
	}
}
