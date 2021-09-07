package requestspecification;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class LearnRequestSpecification {

	
	
	/* show use of request specification */
	@Test
	public void validate_status_code()
	{
		RequestSpecification requestSpecification=given().
				baseUri("https://api.postman.com").
				header("X-Api-Key", "PMAK-612df644a534b4004766973c-7fd33769eb071b51d08d963f786ac92d19");
		
		given(requestSpecification).
		when().get("/workspaces").
		then().log().all().assertThat().statusCode(200);
	}
	
	/*show use  of spec in requestSpecification*/
	@Test
	public void specRequestSpecification()
	{
		RequestSpecification requestSpecification=given().
				baseUri("https://api.postman.com").
				header("X-Api-Key", "PMAK-612df644a534b4004766973c-7fd33769eb071b51d08d963f786ac92d19");
		
		given().spec(requestSpecification).
		when().get("/workspaces").
		then().log().all().assertThat().statusCode(200);
	}
}
