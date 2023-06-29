package swagger.api.store.endpoint;

public class StoreHttpRquest {
	
	public static String base_url = "https://petstore.swagger.io/v2/store";
	
	public static String post_url = base_url+"/order";
	public static String get_url = base_url+"/order/{id}";
	public static String delete_url = base_url+"/order/{id}";
	public static String inventory_url = base_url+"/inventory";
	

}
