package swagger.api.store.endpoint;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.response.Response;
import swagger.api.store.payload.StorePayload;

public class StoreEndPoints {
	
	public static Response create_Order(StorePayload payload)
	{
		Response response = given()
				.contentType("application/json")
				.accept("application/json")
				.body(payload)
		
		
		.when()
			.post(StoreHttpRquest.post_url);
		
		return response;
		
	}


	public static Response find_OrderById(int id)
	{
		Response response = 
		given()
			.pathParam("id",id)
		
		.when()
			.get(StoreHttpRquest.get_url);
		
		
		return response;
	}
	
	public static Response inventory_OrdeById()
	{
		Response response = 
			given()
			.accept("application/json")
				
			.when()
				.get(StoreHttpRquest.inventory_url);
		
		return response;
	}
	
	public static Response delete_OrderById(int id)
	{
		Response response = 
				given()
					.pathParam("id", id)
					
				.when()
					.delete(StoreHttpRquest.delete_url);
		
		return response;
				
				
	}
}
