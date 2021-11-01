package learnPojo;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SimplePojo {

	RequestSpecification request;
	ResponseSpecification response;

	@BeforeClass
	public void beforeClass() {

		request = given().baseUri("https://650df2d1-cf11-4d06-8621-0e89fdd18042.mock.pstmn.io")
				.contentType(ContentType.JSON).log().all();

		response = RestAssured.expect().statusCode(200).contentType(ContentType.JSON);
	}

	@Test
	public void m1() throws JsonProcessingException {

		ActualPojoData pojo=new ActualPojoData("pojovalue1","pojovalue2");
		Response response1=given(request).body(pojo).when().post("/post").then().spec(response).log().all().extract().response();
		JsonPath jsonPath=new JsonPath(response1.asString());
		System.out.println(jsonPath.getString("key1"));
		System.out.println(jsonPath.getString("key2"));
		System.out.println(pojo.getkey1());
		System.out.println(pojo.getkey2());
	}
}
