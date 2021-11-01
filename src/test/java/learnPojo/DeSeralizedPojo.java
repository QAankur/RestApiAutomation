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

public class DeSeralizedPojo {

	RequestSpecification request;
	ResponseSpecification response;

	@BeforeClass
	public void beforeClass() {

		request = given().baseUri("https://7c397dc1-db81-4cc3-ad9e-08371465902a.mock.pstmn.io")
				.contentType(ContentType.JSON).log().all();

		response = RestAssured.expect().statusCode(200).contentType(ContentType.JSON);
	}

	@Test
	public void m1() throws JsonProcessingException {

		ActualPojoData pojo=new ActualPojoData("pojovalue1","pojovalue2");
		ActualPojoData pojoData=given(request).body(pojo).when().post("/postSimpleJson").then().log().all().extract().response().as(ActualPojoData.class);
		
		ObjectMapper mapper=new ObjectMapper();
		String actualdata=mapper.writeValueAsString(pojo);
		String deSerialized=mapper.writeValueAsString(pojoData);
		
		
		System.out.println(actualdata);
		System.out.println(deSerialized);
		
	}
}
