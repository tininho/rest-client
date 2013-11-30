package foo;

import retrofit.RestAdapter;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Hello world!
 *
 */
public class PichClient 
{
	interface PichService{
		@GET("/greeting")
		Greeting getGreeting(@Query("name") String name );
	}
	
    public static void main( String[] args )
    {
    	RestAdapter restAdapter = new RestAdapter.Builder()
        .setServer("http://localhost:8080")
        .build();

    	PichService service = restAdapter.create(PichService.class); 
    	
    	System.out.println("Pich output: "+service.getGreeting("Tino").getContent());
    }
}
