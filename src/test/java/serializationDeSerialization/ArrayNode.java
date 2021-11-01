package serializationDeSerialization;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class ArrayNode {

	RequestSpecification request;
	ResponseSpecification response;

	@BeforeClass
	public void beforeClass() {
		RequestSpecBuilder builder = new RequestSpecBuilder()
				.setBaseUri("https://7c397dc1-db81-4cc3-ad9e-08371465902a.mock.pstmn.io")
				.addHeader("x-mock-match-request-body", "true").setContentType("application/json;charset=utf-8")
				.log(LogDetail.ALL);

		request = builder.build();

		response = RestAssured.expect().statusCode(404).contentType(ContentType.JSON);
	}

	@Test
	public void m1() throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		com.fasterxml.jackson.databind.node.ObjectNode map1 = mapper.createObjectNode();
		com.fasterxml.jackson.databind.node.ObjectNode map2 = mapper.createObjectNode();

		map1.put("id", "5001");
		map1.put("type", "none");

		map2.put("id", "5002");
		map2.put("type", "glazed");

		com.fasterxml.jackson.databind.node.ArrayNode list=mapper.createArrayNode();
		list.add(map1);
		list.add(map2);

		String str = mapper.writeValueAsString(list);
		Response response1 = given(request).body(str).when().post("/post").then().spec(response).log().all().extract()
				.response();
		// System.out.println("Workspace name is : " +
		// JsonPath.from(response1.asString()).getString("workspaces.name"));
	}
}
