package com.restapi;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class RestApiTest {

	
	@Test
	public void toPost() {
		JSONObject obj = new JSONObject();
		obj.put("name", "KempeGowda");
	
				given()
				.header("accept", "application/vnd.github.v3+json")
				.body(obj)
				.auth().oauth2("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")
				.when()
				.post("https://api.github.com/user/repos")
				.then()
				.assertThat()
				.statusCode(201)
				.log().body();
				
	}
	
	@Test
	public void toGet() {
		
		
		given()
		.header("accept", "application/vnd.github.v3+json")
		.queryParam("visibility", "all")
		.auth().oauth2("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")
		.when()
		.get("https://api.github.com/user/repos")
		.then()
		.assertThat()
		.statusCode(200)
		.log().body();
		
}
}
