package oAuthAutomation;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import learnPojo.ActualPojoData;

public class GmailMyProfile {

	RequestSpecification request;
	ResponseSpecification response;
	String accessToken="ya29.a0ARrdaM-o24EAQwmbUTr4xFH4aJLEMNYWwvZ1xuao9rLPSVXutSDtphc3DZpelPVmj8T-HKjt6dLDJFrxC6yWryg8nfvlYKEdOEsSsdeEPTW8DjI4L8KLdMelmCrZI9wMIzTyrfg-A6js9VzTC1Fj1S3LOYLh1w";

	@BeforeClass
	public void beforeClass() {

		RequestSpecBuilder requestSpec= new RequestSpecBuilder().setBaseUri("https://gmail.googleapis.com").addHeader("Authorization", "Bearer " + accessToken ).
				setContentType(ContentType.JSON).log(LogDetail.ALL);
		request=requestSpec.build();

		ResponseSpecBuilder responseSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).log(LogDetail.ALL);
		response=responseSpec.build();
	}

	@Test
	public void m1() throws JsonProcessingException {

		
		given(request).basePath("/gmail/v1").pathParam("userid","restassured1994@gmail.com").
		when().get("/users/{userid}/profile").then().spec(response);
		
	}
}
