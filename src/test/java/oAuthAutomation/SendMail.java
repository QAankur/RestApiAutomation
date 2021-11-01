package oAuthAutomation;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.given;

import java.util.Base64;
import java.util.HashMap;

public class SendMail {

	//https://gmail.googleapis.com/gmail/v1/users/restassured1994@gmail.com/messages/send;
	
	RequestSpecification request;
	ResponseSpecification response;
	String accessToken="ya29.a0ARrdaM-_LMLGy-F247nQeJd1mfKbAmNTHqOoelom36JKKXwvToqqfaGlf1wrEfhQaSwvPnOndqSREWqGG2dEIU5XXE_65yZKAqxq27ZX5yRvUjmPkcYlUjTmnc6I-TZQGDMAK9vZ8bHLG9kKbFbWgh9ZVOP4HA";
	
	@BeforeTest
	public void beforeTest()
	{
		RequestSpecBuilder requestSpec=new RequestSpecBuilder().setBaseUri("https://gmail.googleapis.com/").addHeader("Authorization", "Bearer " + accessToken).
		setContentType(ContentType.JSON).log(LogDetail.ALL);
		request=requestSpec.build();
		
		ResponseSpecBuilder responseSpec=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).log(LogDetail.ALL);
		response=responseSpec.build();
	}
	
	@Test
	public void sendMessage()
	{
		String msg="From: restassured1994@gmail.com\r\n"
				+ "To: ankur.mishra671@gmail.com\r\n"
				+ "Subject: Test Email\r\n"
				+ "\r\n"
				+ "Sending from gmail API";
		
		String encodedMsg=Base64.getUrlEncoder().encodeToString(msg.getBytes());
		HashMap<String,String> map=new HashMap<>();
		map.put("raw", encodedMsg);
		
		given(request).pathParam("userid","restassured1994@gmail.com").basePath("gmail/v1/").body(map).when().
		post("users/{userid}/messages/send").then().spec(response);
		}
}
