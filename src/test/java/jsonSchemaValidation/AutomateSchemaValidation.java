package jsonSchemaValidation;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.log.LogDetail;
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

public class AutomateSchemaValidation {

	RequestSpecification requestSpecification;
	ResponseSpecification responseSpecification;

	@BeforeClass
	public void beforeClass() {
		requestSpecification = given().baseUri("https://postman-echo.com").log().all();

	}
	
	@Test
	public void m1()
	{
		given(requestSpecification).when().get("/get").then().log().all().assertThat().statusCode(200).body(matchesJsonSchemaInClasspath("schemavalidator.json"));
	}
}
