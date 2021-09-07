package queryParameter;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class GetPostRequest {

	RequestSpecification requestSpecification;
	ResponseSpecification responseSpecification;

	@BeforeClass
	public void beforeClass() {
		requestSpecification = given().baseUri("https://postman-echo.com").log().all();

	}

	// Single query parameter
	@Test
	public void m1() {
		given(requestSpecification).param("Key1", "valu1").when().get("/get").then().log().all();
		given(requestSpecification).param("Key1", "valu1").param("key2", "Value2").when().get("/get").then().log()
				.all();
	}

	// multi query parameter
	@Test
	public void m2() {
		given(requestSpecification).param("Key1", "valu1").param("key2", "Value2").when().get("/get").then().log()
				.all();
	}

	// multiQuery parameter using hashMap
	@Test
	public void m3() {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("Key1", "Value1");
		map.put("Key2", "Value2");

		given(requestSpecification).queryParams(map).when().get("/get").then().log().all();
		
		//given(requestSpecification).queryParams("key1", "value1", "key2", "value2").when().get("/get").then().log().all();
	}

	// Multi value Query parameter
	@Test
	public void m4() {
		
		//given(requestSpecification).queryParam("key1", "value1,value2,value3").when().get("/get").then().log().all();
		given(requestSpecification).queryParam("key1", "value1;value2;value3").when().get("/get").then().log().all();
	}
	
}
