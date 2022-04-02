package com.reqres;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.equalTo;
/**
 * Create a dummy Api Test Class
 * @author Human
 *
 */
public class DummyApiTest {

	@Test
	public void retrieve() {
		Response res = given()
		.queryParam("page", 2)
		.when()
		.get("https://reqres.in/api/users");
		
		int i = res.jsonPath().get("page");
		
		System.out.println(i);
		
		 res.then()
		.assertThat()
		.statusCode(200)
		.body("data[1].first_name",equalTo("Lindsay"))
		.log().all();
	}
	@Test
	public void getList() {
		baseURI="https://reqres.in";
		
		Response Resp = given().
				when().
				get("/api/users?page=2");
		
				String res = Resp.then().
				assertThat().statusCode(200).and().
				contentType(ContentType.JSON).and().
				header("server", "cloudflare").and(). 
				header("x-powered-by","Express").and().
				body("page",equalTo(2)).and().
				body("data[1].first_name",equalTo("Lindsay")).and().
				extract().
				response().asString();
		
				Resp.prettyPrint();
		System.out.println("Response is\t"+res);
		
	}
}