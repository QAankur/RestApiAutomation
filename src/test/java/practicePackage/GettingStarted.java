package practicePackage;

import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import static io.restassured.RestAssured.given;

public class GettingStarted {

	@Test
	public void sampleTest()
	{
		given().baseUri("https://api.getpostman.com").header("X-Api-Key", "PMAK-612df644a534b4004766973c-7fd33769eb071b51d08d963f786ac92d19").
		when().get("/workspaces").then().log().all().assertThat().statusCode(200);
		
	}
	
	@Test
	public void validateResponse1()
	{
		given().baseUri("https://api.getpostman.com").header("X-Api-Key", "PMAK-612df644a534b4004766973c-7fd33769eb071b51d08d963f786ac92d19").
		when().get("/workspaces").then().log().all().assertThat().statusCode(200).body("workspaces.name", hasItems("My Workspace","2ndWorkspace","workspace4"))
		.body("workspaces.type", hasItems("personal")).body("workspaces.name[0]", equalTo("My Workspace")).body("workspaces.name[1]", equalTo("2ndWorkspace")).
		body("workspaces.name[2]", is(equalTo("workspace4"))).body("workspaces.size()", equalTo(3));
		
	}
	
	@Test
	public void validateResponse()
	{
		String name=given().baseUri("https://api.getpostman.com").header("X-Api-Key", "PMAK-612df644a534b4004766973c-7fd33769eb071b51d08d963f786ac92d19").
		when().get("/workspaces").then().log().all().assertThat().statusCode(200).extract().response().path("workspaces[0].name");
		assertThat(name, equalTo("My Workspace"));
		
	}
	@Test
	public void validateResponse2()
	{
		Response res=given().baseUri("https://api.getpostman.com").header("X-Api-Key", "PMAK-612df644a534b4004766973c-7fd33769eb071b51d08d963f786ac92d19").
		when().get("/workspaces").then().log().all().assertThat().statusCode(200).extract().response();
		//System.out.println(res.path("workspaces[0].name"));
		//JsonPath jp=new JsonPath(res.asString());
		//System.out.println(jp.getString("workspaces[0].name"));
		
	}
	@Test
	public void validateResponse3()
	{
		String name=given().baseUri("https://api.getpostman.com").header("X-Api-Key", "PMAK-612df644a534b4004766973c-7fd33769eb071b51d08d963f786ac92d19").
		when().get("/workspaces").then().log().all().assertThat().statusCode(200).extract().response().asString();
		System.out.println(JsonPath.from(name).getString("workspaces[0].name"));
	}
}
