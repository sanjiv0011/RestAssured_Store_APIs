package Date;


import java.text.SimpleDateFormat;
import java.util.Date;


public class TestNGDateTimeExample {


	    public static String Date() {
	       	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
	        Date currentDate = new Date();
	        String formattedDate = dateFormat.format(currentDate);
	        return formattedDate;
	        //System.out.println("Current formatted date: " + formattedDate);
	    }
	

}
