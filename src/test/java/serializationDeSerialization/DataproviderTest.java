package serializationDeSerialization;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import learnPojo.WorkSpaceRoot;
import learnPojo.Workspace;

public class DataproviderTest {

	RequestSpecification request;
	ResponseSpecification response;

	@BeforeClass
	public void beforeClass() {

		request = given().baseUri("https://api.postman.com")
				.header("X-Api-Key", "PMAK-612df644a534b4004766973c-7fd33769eb071b51d08d963f786ac92d19")
				.contentType(ContentType.JSON).log().all();

		response = RestAssured.expect().statusCode(200).contentType(ContentType.JSON);
	}

	@Test(dataProvider="workspaceData")
	public void m1(String name, String type, String desc) throws JsonProcessingException {

		Workspace workspace = new Workspace(name, type, desc);
		WorkSpaceRoot root = new WorkSpaceRoot(workspace);


		WorkSpaceRoot deSerializedPojo = given(request).body(root).when().post("/workspaces").then().spec(response).log().all()
				.extract().response().as(WorkSpaceRoot.class);
		
		System.out.println("Workspace to be created " + workspace.getName());	
		System.out.println("Workspace that is  created " + deSerializedPojo.getWorkspace().getId());
	}
	
	@DataProvider(name = "workspaceData")
	public Object[][] sendData()
	{
		Object[][] obj=new Object[2][3];
		obj[0][0] ="workspace10001";
		obj[0][1] ="personal";
		obj[0][2] ="This is for demo1";
		obj[1][0] ="workspace20001";
		obj[1][1] ="personal";
		obj[1][2] ="This is for demo2";
		return obj;
	}
}
