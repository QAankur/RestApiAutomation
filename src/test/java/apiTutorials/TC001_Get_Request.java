package apiTutorials;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class TC001_Get_Request {

	@Test
	void getWeatherDetails()
	{
		given().baseUri("https://api.postman.com").header("X-Api-Key", "PMAK-612df644a534b4004766973c-7fd33769eb071b51d08d963f786ac92d19").
		when().get("/workspaces").
		then().
		assertThat().statusCode(201).log().all();
	}
	
	@Test
	void validateResponseBody()
	{
		given().
				baseUri("https://api.postman.com").
				header("X-Api-Key", "PMAK-612df644a534b4004766973c-7fd33769eb071b51d08d963f786ac92d19").
		when().
				get("/workspaces").
		then().
				log().all().
				assertThat().
				statusCode(200).
				body("workspaces.name",hasItems("My Workspace","2ndWorkspace"),
				"workspaces.type",hasItems("personal", "personal1"),
				"workspaces[0].name",equalTo("My Workspace1"));
				
	}
	
	@Test
	void extract_Response()
	{
		Response res=given().
		baseUri("https://api.postman.com").
		header("X-Api-Key", "PMAK-612df644a534b4004766973c-7fd33769eb071b51d08d963f786ac92d19").
		when().
		get("/workspaces").
		then().
		log().all().
		assertThat().
		statusCode(200).
		extract().
		response();
		
		System.out.println(res.toString());
	}
	
	@Test
	void extract_Single_Response()
	{
		/*Response res=given().
		baseUri("https://api.postman.com").
		header("X-Api-Key", "PMAK-612df644a534b4004766973c-7fd33769eb071b51d08d963f786ac92d19").
		when().
		get("/workspaces").
		then().
		assertThat().
		statusCode(200).
		extract().
		response();
		*/
		
		String name=given().
				baseUri("https://api.postman.com").
				header("X-Api-Key", "PMAK-612df644a534b4004766973c-7fd33769eb071b51d08d963f786ac92d19").
				when().
				get("/workspaces").
				then().
				assertThat().
				statusCode(200).
				extract().
				response().path("workspaces[0].name");
		System.out.println(name);
		//System.out.println(JsonPath.from(res.asString()).getString("workspaces[0].name"));
		
		/*JsonPath jsonPath=new JsonPath(res.asString());
		System.out.println(jsonPath.getString("workspaces[0].name"));*/
	}
}
