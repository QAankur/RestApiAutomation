package handleDifferentDataTypePojo;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.skyscreamer.jsonassert.Customization;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.skyscreamer.jsonassert.ValueMatcher;
import org.skyscreamer.jsonassert.comparator.CustomComparator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import learnPojo.WorkSpaceRoot;
import learnPojo.Workspace;

public class Automation {


	@Test
	public void m1() throws JsonProcessingException, JSONException {

		Header header=new Header("Content-Type","application/json");
		List<Header> headerList=new ArrayList<Header>();
		headerList.add(header);
		
		Body body=new Body("raw","{\"data\": \"123\"}");
		RequestRequest request=new RequestRequest("https://postman-echo.com/post","POST",headerList,body,"This is a sample POST Request");
		
		RequestRootRequest requestRoot=new RequestRootRequest("This is a folder",request);
		List<RequestRootRequest> rootList=new  ArrayList<RequestRootRequest>();
		rootList.add(requestRoot);
		
		FolderRequest folder=new FolderRequest("This is a folder",rootList);
		List<FolderRequest> folderlist=new ArrayList<FolderRequest>();
		folderlist.add(folder);
		
		Info info=new Info("Sample Collection 101","This is just a sample collection.","https://schema.getpostman.com/json/collection/v2.1.0/collection.json");

		CollectionRequest collection=new CollectionRequest(info,folderlist);
		
		CollectionRootRequest root=new CollectionRootRequest(collection);
		
		String uid=given().baseUri("https://api.getpostman.com")
		.header("X-Api-Key", "PMAK-612df644a534b4004766973c-7fd33769eb071b51d08d963f786ac92d19")
		.contentType(ContentType.JSON).body(root).log().all().when().post("/collections").then().log().all().extract().response().path("collection.uid");
		
		CollectionRootBaseResponse deserialCollectionRoot=given().baseUri("https://api.getpostman.com")
				.header("X-Api-Key", "PMAK-612df644a534b4004766973c-7fd33769eb071b51d08d963f786ac92d19")
				.contentType(ContentType.JSON).pathParam("uid", uid).when().get("/collections/{uid}").
				then().log().all().extract().response().as(CollectionRootBaseResponse.class);
		
		System.out.println(" This is my uid : " + uid);
		
		ObjectMapper objectMapper=new ObjectMapper();
		String collectionRootStr=objectMapper.writeValueAsString(root);
		String deserialStr=objectMapper.writeValueAsString(deserialCollectionRoot);
		
		JSONAssert.assertEquals(collectionRootStr, deserialStr, new CustomComparator(JSONCompareMode.LENIENT,
				new Customization("collection.item[*].item[*].request.url",new 
						ValueMatcher<Object>() {
							public boolean equal(Object o1, Object o2) {
								return true;
							}	
				})));	
		
		
	}
}
