package api.test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.net.ResponseCache;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndpoints;
import api.payload.User;
import io.restassured.response.Response;

public class DDTests {
	
//	@Test(priority = 1)   //Need to add the Data providers here
	public void testPostUser(String userID, String userName, String fName, String lname, String useremail, String pwd) {
		
		User userPayLoad=new User();
		
		userPayLoad.setId(Integer.parseInt(userID));
		userPayLoad.setUsername(userName);
		userPayLoad.setFirstName(fName);
		userPayLoad.setLastName(lname);
		userPayLoad.setEmail(useremail);
		userPayLoad.setPassword(pwd);
		
		Response response=UserEndpoints.createUser(userPayLoad);
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
		
	}
	
//	@Test(priority = 2) //Need to add the Data providers here
	public void testDeleteUserByName(String userName) {
		
		Response response=UserEndpoints.deleteUser(userName);
		AssertJUnit.assertEquals(response.getStatusCode(), 200);	
		
	}

}
