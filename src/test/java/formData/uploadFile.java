package formData;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class uploadFile {

	RequestSpecification requestSpecification;
	ResponseSpecification responseSpecification;

	@BeforeClass
	public void beforeClass() {
		requestSpecification = given().baseUri("https://postman-echo.com").log().all();

	}
	
	@Test
	public void m1()
	{
		String attributes="{\"name\":\"formData.txt\" , \"parent\":{\"id\":\"123456\"}}";
		given(requestSpecification).multiPart("Key1", new File("C:\\Users\\Anuj\\Selenium_Utilities\\RestApiAutomation\\DataFiles\\formData.txt")).
		multiPart("attributes",attributes,"application/json").when().get("/post").then().log().all();
	}
}
