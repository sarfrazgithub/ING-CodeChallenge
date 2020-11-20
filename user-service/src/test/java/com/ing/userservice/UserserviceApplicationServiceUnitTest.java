package com.ing.userservice;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.ing.controller.UserController;
import com.ing.entities.User;
import com.ing.service.UserService;


@RunWith(SpringRunner.class)
@WebMvcTest(controllers = UserController.class)
@ContextConfiguration(classes = {
	   
		UserController.class
	})
	@WebAppConfiguration
class UserserviceApplicationServiceUnitTest {

	private List<User> userList;
	 @BeforeEach                           
	    void setUp() {                               
	       this.userList = new ArrayList<>();  
	       User user1 = new User();
	       user1.setUserId(1);
	       user1.setFirstname("Steve");
	       user1.setLastname("Waugh");
	       this.userList.add(user1); 
	       User user2 = new User();
	       user1.setUserId(1);
	       user1.setFirstname("Mark");
	       user1.setLastname("Waugh");
	       this.userList.add(user2); 
	       User user3 = new User();
	       user1.setUserId(1);
	       user1.setFirstname("Steve");
	       user1.setLastname("Smith");
	       this.userList.add(user3); 
	       
	 System.out.println("BEFOREEEEEEEEEEEEEEEe");
	    }
	@MockBean                           
    private UserService userService; 
	                         
	
	@Test
	void fetchUserById() throws Exception{
		final User user1 = new User();
	       user1.setUserId(1);
	       user1.setFirstname("Steve");
	       user1.setLastname("Waugh");
	      Mockito.when(userService.findByUserid(Mockito.anyInt())).thenReturn(userList.get(0));
	    
	      
	       
	       JSONAssert.assertEquals(user1.getFirstname(), userService.findByUserid(10).getFirstname(), false);
	
	}
	
}
