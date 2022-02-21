
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

public class Test_GET {
    @Test
    void test_01() {
        
       Response response = RestAssured.get("https://reqres.in/api/users?page=2");
       
       System.out.println(response.asString());
       System.out.println(response.getBody().asString());
       System.out.println(response.getStatusCode());
       System.out.println(response.getStatusLine());
       System.out.println(response.getHeader("content-type"));
       System.out.println(response.getTime());

         int statuscode=response.getStatusCode();
        Assert.assertEquals(statuscode, 200);
   }
    @Test
    void test_2() {
    	given().
    	get("https://reqres.in/api/users?page=2").then().statusCode(200).body("data.id[0]",equalTo(7));
    }
	
}
