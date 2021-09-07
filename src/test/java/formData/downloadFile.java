package formData;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class downloadFile {

	RequestSpecification requestSpecification;
	ResponseSpecification responseSpecification;

	@BeforeClass
	public void beforeClass() {
		requestSpecification = given().baseUri("https://raw.githubusercontent.com").log().all();

	}

	@Test
	public void m1() throws IOException
	{
		byte[] b=given(requestSpecification).when().get("/appium/appium/master/sample-code/apps/ApiDemos-debug.apk").
		then().extract().response().asByteArray();
		
		OutputStream os=new FileOutputStream(new File("ApiDemos-debug.apk"));
		os.write(b);
		os.close();
				}

}
