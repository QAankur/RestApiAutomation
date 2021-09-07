package apiTutorials;

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

public class LoggingTutorials {

	@Test
	public void ReqResLogging()
	{
		given().
		baseUri("https://api.postman.com").
		header("X-Api-Key", "PMAK-612df644a534b4004766973c-7fd33769eb071b51d08d963f786ac92d19").
		log().all().
		when().
		get("/workspaces").
		then().
		log().all().
		assertThat().statusCode(200);
	}
	
	@Test
	public void LogIfAnyError()
	{
		given().
		baseUri("https://api.postman.com").
		header("X-Api-Key", "PMAK-612df644a534b4004766973c-7fd33769eb071b51d08d963f786ac92d19").
		log().all().
		when().
		get("/workspaces").
		then().log().ifError().
		assertThat().statusCode(200);
	}
	
	@Test
	public void LogIfValidationFail()
		{
			given().
			baseUri("https://api.postman.com").
			header("X-Api-Key", "PMAK-612df644a534b4004766973c-7fd33769eb071b51d08d963f786ac92d19").
			log().ifValidationFails().
			when().
			get("/workspaces").
			then().log().ifValidationFails().
			assertThat().statusCode(201);
		}
	@Test
	public void blackListHeaders()
	{
		given().
		baseUri("https://api.postman.com").
		header("X-Api-Key", "PMAK-612df644a534b4004766973c-7fd33769eb071b51d08d963f786ac92d19").
		config(config.logConfig(LogConfig.logConfig().blacklistHeader("X-Api-Key"))).
		log().all().
		when().
		get("/workspaces").
		then().log().all().
		assertThat().statusCode(200);
	}
}
