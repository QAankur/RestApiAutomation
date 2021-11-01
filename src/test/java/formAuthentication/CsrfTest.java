package formAuthentication;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.FormAuthConfig;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.session.SessionFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
public class CsrfTest {

	@BeforeClass
	public void beforeClass() {
		RestAssured.requestSpecification = new RequestSpecBuilder().setRelaxedHTTPSValidation()
				.setBaseUri("https://localhost:8081").build();
	}

	@Test
	public void authentication() {
		
		SessionFilter sFilter=new SessionFilter();
		given().auth().form("dan", "dan123", new FormAuthConfig("/signin", "txtUsername", "txtPassword").withAutoDetectionOfCsrf()).filter(sFilter).log().all()
				.when().get("/login").
		then().log().all().assertThat().statusCode(200);
		
		
		given().sessionId(sFilter.getSessionId()).log().all().
		when().get("/profile/index").
		then().
		log().all().
		assertThat().
		statusCode(200).
		body("html.body.div.p", equalTo("This is User Profile\\Index. Only authenticated people can see this"));
		
	}
	
}
