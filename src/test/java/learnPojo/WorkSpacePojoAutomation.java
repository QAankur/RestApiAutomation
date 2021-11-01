package learnPojo;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

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

public class WorkSpacePojoAutomation {

	RequestSpecification request;
	ResponseSpecification response;

	@BeforeClass
	public void beforeClass() {

		request = given().baseUri("https://api.postman.com")
				.header("X-Api-Key", "PMAK-612df644a534b4004766973c-7fd33769eb071b51d08d963f786ac92d19")
				.contentType(ContentType.JSON).log().all();

		response = RestAssured.expect().statusCode(200).contentType(ContentType.JSON);
	}

	@Test
	public void m1() throws JsonProcessingException {

		Workspace workspace = new Workspace("workspace123", "personal", "This is for testing purpose");
		WorkSpaceRoot root = new WorkSpaceRoot(workspace);


		WorkSpaceRoot deSerializedPojo = given(request).body(root).when().post("/workspaces").then().spec(response).log().all()
				.extract().response().as(WorkSpaceRoot.class);
		
		System.out.println("Workspace to be created " + workspace.getName());	
		System.out.println("Workspace that is  created " + deSerializedPojo.getWorkspace().getId());
	}
}
