package multiplePayload;

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

public class UseJsonArrayAsList {

	RequestSpecification request;
	ResponseSpecification response;
	@BeforeClass
	public void beforeClass()
	{
		RequestSpecBuilder builder=new RequestSpecBuilder().setBaseUri("https://7c397dc1-db81-4cc3-ad9e-08371465902a.mock.pstmn.io").
		addHeader("x-mock-match-request-body", "true")
		.setContentType("application/json;charset=utf-8")
		.log(LogDetail.ALL);
		
		request=builder.build();
		
		response=RestAssured.expect().statusCode(404).contentType(ContentType.JSON);
	}
	
	@Test
	public void m1()
	{
		HashMap<String,String> map1=new HashMap<String,String>();
		map1.put("id","5001");
		map1.put("type","none");
		HashMap<String,String> map2=new HashMap<String,String>();
		map2.put("id","5002");
		map2.put("type","glazed");
		
		List<HashMap<String,String>> list=new ArrayList<HashMap<String,String>>();
		list.add(map1);
		list.add(map2);
		
		Response response1=given(request).body(list).
		when().post("/post").then().
		spec(response).log().all().extract().response();
		//System.out.println("Workspace name is : " + JsonPath.from(response1.asString()).getString("workspaces.name"));
	}
}
