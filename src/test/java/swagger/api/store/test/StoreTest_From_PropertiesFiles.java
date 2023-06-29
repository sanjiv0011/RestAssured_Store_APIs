package swagger.api.store.test;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import com.github.javafaker.Faker;

import io.restassured.response.Response;
import swagger.api.store.endpoint.StoreEndPoints_From_PropertiesFiles;
import swagger.api.store.payload.StorePayload;

public class StoreTest_From_PropertiesFiles {
	
	Faker faker;
	StorePayload payload;
	
	public Logger logger;
	
	@BeforeClass
	public  void setup()
	{
		faker = new Faker();
		payload = new StorePayload();
		
		payload.setId(faker.number().numberBetween(1,50));
		payload.setPetId(faker.idNumber().hashCode());
		payload.setQuantity(faker.number().numberBetween(1,2));
		payload.setShipDate(Date.TestNGDateTimeExample.Date());
		payload.setStatus("placed");
		payload.setComplete(true);
		
		// logs
		logger = LogManager.getLogger(this.getClass());
	
	}
	
	@Test(priority =1)
	public void test_CreateOrder()
	{
		logger.info("*Creating User*");
		Response resposne = StoreEndPoints_From_PropertiesFiles.create_Order(payload);
		resposne.then()
			.log().all();
		
		Assert.assertEquals(resposne.getStatusCode(),200);
		logger.info("*User Created*");
	
	}
	
	@Test(priority =2 )
	public void test_FindOrdersById()
	{
		logger.info("*Reading Odres info*");
		Response response = StoreEndPoints_From_PropertiesFiles.find_OrderById(this.payload.getId());
		response.then()
			.log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
	
	}
	
	@Test(priority =3)
	public void test_InventoryDetails()
	{
		logger.info("*Reading Inventory info*");
		Response response = StoreEndPoints_From_PropertiesFiles.inventory_OrdeById();
		response.then()
			.log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority = 4 /*,dependsOnMethods = {"test_InventoryDetails"}*/)
	public void test_DeteleOrders()
	{
		logger.info("*Deleting users*");
		Response response = StoreEndPoints_From_PropertiesFiles.delete_OrderById(this.payload.getId());
		response.then()
			.log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("*Users Deleted*");
	}
	
	
	
	

}
