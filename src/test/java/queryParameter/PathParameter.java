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

public class PathParameter {

	RequestSpecification requestSpecification;
	ResponseSpecification responseSpecification;

	@BeforeClass
	public void beforeClass() {
		requestSpecification = given().baseUri("https://reqres.in").log().all();

	}
	
	@Test
	public void m1()
	{
		given(requestSpecification).pathParam("users","2").when().get("/api/users/{users}").then().log().all();
	}
}
