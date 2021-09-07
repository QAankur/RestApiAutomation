package filters;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
public class ReqResFilter {

	RequestSpecification requestSpecification;
	ResponseSpecification responseSpecification;

	@BeforeClass
	public void beforeClass() {
		requestSpecification = given().baseUri("https://postman-echo.com").log().all();

	}
	@Test
	public void m1()
	{
		given().baseUri("https://postman-echo.com").filter(new RequestLoggingFilter(LogDetail.BODY)).filter(new ResponseLoggingFilter(LogDetail.STATUS)).
		when().get("/get").then().assertThat().statusCode(200);
	}
}
