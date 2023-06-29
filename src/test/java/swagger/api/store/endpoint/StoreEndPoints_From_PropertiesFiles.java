package swagger.api.store.endpoint;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ResourceBundle;

import io.restassured.response.Response;
import swagger.api.store.payload.StorePayload;

public class StoreEndPoints_From_PropertiesFiles {
	
	
	static ResourceBundle  getURL()
	{
		ResourceBundle routes = ResourceBundle.getBundle("Routes");
		return routes;
	}
	
	
	
	public static Response create_Order(StorePayload payload)
	{
		// to get fetch the url from the routes.properties files
		String post_url = getURL().getString("post_url");
				
		Response response = given()
				.contentType("application/json")
				.accept("application/json")
				.body(payload)
		
		
		.when()
			.post(post_url);
		
		return response;
		
	}


	public static Response find_OrderById(int id)
	{
		
		// to get fetch the url from the routes.properties files
		String get_url = getURL().getString("get_url");
				
		Response response = 
		given()
			.pathParam("id",id)
		
		.when()
			.get(get_url);
		
		
		return response;
	}
	
	public static Response inventory_OrdeById()
	{
		
		// to get fetch the url from the routes.properties files
		String inventory_url = getURL().getString("inventory_url");
				
		Response response = 
			given()
			.accept("application/json")
				
			.when()
				.get(inventory_url);
		
		return response;
	}
	
	public static Response delete_OrderById(int id)
	{
		
		// to get fetch the url from the routes.properties files
		String delete_url = getURL().getString("delete_url");
				
		Response response = 
				given()
					.pathParam("id", id)
					
				.when()
					.delete(delete_url);
		
		return response;
				
				
	}
}
