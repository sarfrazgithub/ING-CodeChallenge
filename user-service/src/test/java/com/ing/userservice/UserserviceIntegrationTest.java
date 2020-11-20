package com.ing.userservice;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.ing.UserserviceApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=UserserviceApplication.class)
@AutoConfigureMockMvc
public class UserserviceIntegrationTest {


	
	 @Autowired
	 private MockMvc mockMvc;
    
	@Test
	public void userFound() throws Exception {


	this.mockMvc.perform(get("/fetchuser/101").header("Authorization","Bearer ").contentType(MediaType.APPLICATION_JSON)).andDo(print()).
				andExpect(status().isOk());
	
	
	
}
	
	@Test
	public void notAuthorisedWithOutHeader() throws Exception {
    //sending request without header

	this.mockMvc.perform(get("/fetchuser/101").contentType(MediaType.APPLICATION_JSON)).andDo(print()).
				andExpect(status().isUnauthorized());
	
	
	
}
	@Test
	public void userNotFound() throws Exception {

  this.mockMvc.perform(get("/fetchuser/10121").header("Authorization","Bearer ").contentType(MediaType.APPLICATION_JSON)).andDo(print()).
				andExpect(status().isNotFound());
	
	
	
}
}