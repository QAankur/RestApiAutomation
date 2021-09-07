package formData;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SendFormData {

	RequestSpecification requestSpecification;
	ResponseSpecification responseSpecification;

	@BeforeClass
	public void beforeClass() {
		requestSpecification = given().baseUri("https://postman-echo.com").log().all();

	}

	// sending normal multi part data 
	@Test
	public void m1()
	{
		given(requestSpecification).multiPart("Key1","Value1").when().post("/post").then().log().all();
	}
	
}
