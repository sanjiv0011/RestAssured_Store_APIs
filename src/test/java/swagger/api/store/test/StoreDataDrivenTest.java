package swagger.api.store.test;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import swagger.api.store.endpoint.StoreEndPoints;
import swagger.api.store.payload.StorePayload;
import swagger.api.store.utilitites.DataProviders;

public class StoreDataDrivenTest {

	
	@Test(priority = 1, dataProvider = "Data1", dataProviderClass = DataProviders.class)
	public void testPostOrder(String id, String petId, String quantity, String status, boolean complete,String shipDate)
	{
		StorePayload payload = new StorePayload();
		
		payload.setId(Integer.parseInt(id));
		payload.setPetId(Integer.parseInt(petId));
		payload.setQuantity(Integer.parseInt(quantity));
		payload.setStatus(status);
		payload.setComplete(complete);
		payload.setStatus(shipDate);
		

		Response resposne = StoreEndPoints.create_Order(payload);
		resposne.then()
			.log().all();
		
		Assert.assertEquals(resposne.getStatusCode(),200);
	
	}
	
	//@Test(priority =2, dataProvider = "id", dataProviderClass = DataProviders.class)
	public void find_OrderById(int id)
	{
		Response response = StoreEndPoints.find_OrderById(id);
		response.then()
			.log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
	
	}
}
