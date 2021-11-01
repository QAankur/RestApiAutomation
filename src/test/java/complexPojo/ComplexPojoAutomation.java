package complexPojo;

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

public class ComplexPojoAutomation {


	@Test
	public void m1() throws JsonProcessingException, JSONException {

		/*Header header=new Header("Content-Type","application/json");
		List<Header> headerList=new ArrayList<Header>();
		headerList.add(header);
		
		Body body=new Body("raw","{\"data\": \"123\"}");
		Request request=new Request("https://postman-echo.com/post","POST",headerList,body,"This is a sample POST Request");
		
		RequestRoot requestRoot=new RequestRoot("This is a folder",request);
		List<RequestRoot> rootList=new  ArrayList<RequestRoot>();
		rootList.add(requestRoot);
		
		Folder folder=new Folder("This is a folder",rootList);
		List<Folder> folderlist=new ArrayList<Folder>();
		folderlist.add(folder);
		
		Info info=new Info("Sample Collection 101","This is just a sample collection.","https://schema.getpostman.com/json/collection/v2.1.0/collection.json");

		Collection collection=new Collection(info,folderlist);
		
		CollectionRoot root=new CollectionRoot(collection);
		
		String uid=given().baseUri("https://api.getpostman.com")
		.header("X-Api-Key", "PMAK-612df644a534b4004766973c-7fd33769eb071b51d08d963f786ac92d19")
		.contentType(ContentType.JSON).body(root).when().post("/collections").then().log().all().extract().response().path("collection.uid");
		
		CollectionRoot deserialCollectionRoot=given().baseUri("https://api.getpostman.com")
				.header("X-Api-Key", "PMAK-612df644a534b4004766973c-7fd33769eb071b51d08d963f786ac92d19")
				.contentType(ContentType.JSON).pathParam("uid", uid).when().get("/collections/{uid}").
				then().log().all().extract().response().as(CollectionRoot.class);
		
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
		*/
		
	}
}
