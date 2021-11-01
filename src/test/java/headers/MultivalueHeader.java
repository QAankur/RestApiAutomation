package headers;

import org.apache.xmlbeans.impl.common.SystemCache;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.List;

public class MultivalueHeader {

	@Test
	public void test()
	{
		given().baseUri("https://7ebd68eb-ae07-4904-b3ce-5a6d14bfb809.mock.pstmn.io").header("header", "value1")
		.header("x-mock-match-request-headers", "header")
		.when()
		.get("/get").then().log().all().assertThat().statusCode(200);
	}
	
	@Test
	public void test2()
	{
		Header h1=new Header("header", "value2");
		Header h2=new Header("x-mock-match-request-headers", "header");
		given().baseUri("https://7ebd68eb-ae07-4904-b3ce-5a6d14bfb809.mock.pstmn.io").header(h1)
		.header(h2)
		.when()
		.get("/get").then().log().all().assertThat().statusCode(200);
	}
	
	@Test
	public void test3()
	{
		Header h1=new Header("header", "value2");
		Header h2=new Header("x-mock-match-request-headers", "header");
		Headers h3=new Headers(h1,h2);
		given().baseUri("https://7ebd68eb-ae07-4904-b3ce-5a6d14bfb809.mock.pstmn.io").headers(h3)
		.when()
		.get("/get").then().log().all().assertThat().statusCode(200);
	}
	
	@Test
	public void test4()
	{
		
		HashMap<String,String> h=new HashMap<>();
		h.put("header", "value2");
		h.put("x-mock-match-request-headers", "header");
		given().baseUri("https://7ebd68eb-ae07-4904-b3ce-5a6d14bfb809.mock.pstmn.io").headers(h)
		.when()
		.get("/get").then().log().all().assertThat().statusCode(200);
	}
	
	@Test
	public void test5()
	{
		given().baseUri("https://7ebd68eb-ae07-4904-b3ce-5a6d14bfb809.mock.pstmn.io").
		header("multivalueHeader","value1","value3").log().headers()
		.when()
		.get("/get").then().log().all().assertThat().statusCode(200);
	}
	
	@Test
	public void test6()
	{
		Header h1=new Header("multivalueHeader", "value2");
		Header h2=new Header("multivalueHeader", "value2");
		Headers h3=new Headers(h1,h2);
		given().baseUri("https://7ebd68eb-ae07-4904-b3ce-5a6d14bfb809.mock.pstmn.io").headers(h3)
		.when()
		.get("/get").then().log().all().assertThat().statusCode(200);
	}
	
	@Test
	public void test7()
	{
		given().baseUri("https://7ebd68eb-ae07-4904-b3ce-5a6d14bfb809.mock.pstmn.io").header("header", "value1")
		.header("x-mock-match-request-headers", "header")
		.when()
		.get("/get").then().log().all().assertThat().statusCode(200).header("responseHeader","resValue1");
	}
	
	@Test
	public void test8()
	{
		Headers header=given().baseUri("https://7ebd68eb-ae07-4904-b3ce-5a6d14bfb809.mock.pstmn.io").header("header", "value1")
		.header("x-mock-match-request-headers", "header")
		.when()
		.get("/get").then().log().all().assertThat().statusCode(200).extract().headers();
		
		for(Header h: header)
		{
			System.out.println(h.getName() + " " + h.getValue());
		}
	}
	
	@Test
	public void test9()
	{
		Headers header=given().baseUri("https://7ebd68eb-ae07-4904-b3ce-5a6d14bfb809.mock.pstmn.io").header("header", "value1")
		.header("x-mock-match-request-headers", "header")
		.when()
		.get("/get").then().assertThat().statusCode(200).extract().headers();
		
		List<String> list=header.getValues("multiValueHeader");
		for(String l:list)
		{
			System.out.println("############" + l);
		}
	}
}
