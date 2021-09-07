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

import java.io.FileNotFoundException;
import java.io.PrintStream;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
public class ReuseFilter {

	RequestSpecification requestSpecification;
	ResponseSpecification responseSpecification;

	@BeforeClass
	public void beforeClass() throws FileNotFoundException {
		PrintStream ps=new PrintStream("logging.txt");
		requestSpecification = given().baseUri("https://postman-echo.com").
		baseUri("https://postman-echo.com").filter(new RequestLoggingFilter(ps)).filter(new ResponseLoggingFilter(ps));
	}
	@Test
	public void m1()
	{
		given(requestSpecification).
		when().get("/get").then().assertThat().statusCode(200);
	}
}
