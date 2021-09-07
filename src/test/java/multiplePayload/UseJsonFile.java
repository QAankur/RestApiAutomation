package multiplePayload;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class UseJsonFile {

	RequestSpecification request;
	ResponseSpecification response;
	@BeforeClass
	public void beforeClass()
	{
		
		request=given().baseUri("https://api.postman.com").
				header("X-Api-Key", "PMAK-612df644a534b4004766973c-7fd33769eb071b51d08d963f786ac92d19")
				.contentType(ContentType.JSON).log().all();
		
		response=RestAssured.expect().statusCode(200).contentType(ContentType.JSON);
	}
	
	@Test
	public void m1()
	{
		File file=new File("C:\\Users\\Anuj\\Selenium_Utilities\\RestApiAutomation\\src\\main\\java\\resources\\requestdata.json");
		Response response1=given(request).body(file).
		when().post("/workspaces").then().
		spec(response).log().all().extract().response();
		System.out.println("Workspace name is : " + JsonPath.from(response1.asString()).getString("workspace.name"));
	}
}
