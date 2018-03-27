package com.tausif.todoz;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.tausif.todoz.TodozApplication;
import com.tausif.todoz.entity.User;
import com.tausif.todoz.service.UserServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
		classes=TodozApplication.class
		)
@AutoConfigureMockMvc
@TestPropertySource(locations="classpath:application.properties")
public class UserControllerTests {

	@Autowired
	MockMvc mockMvc;
	
    @Test
    public void testUserSignUp() throws Exception
    {
    	String randStr = String.valueOf(Math.random());
		String requestJson="{\"username\":\"tstusr"+randStr+"\",\"password\":\"tstpass"+randStr+"\"}";
		
		mockMvc.perform(
				post("/public/user/sign-up")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(requestJson))
				.andExpect(status().isOk());
    }
    
    @Test
    public void testUserSignIn() throws Exception
    {
    	String randStr = String.valueOf(Math.random());
		String requestJson="{\"username\":\"tstusr"+randStr+"\",\"password\":\"tstpass"+randStr+"\"}";
		
		mockMvc.perform(
				post("/public/user/sign-up")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(requestJson))
				.andExpect(status().isOk());
		
		MvcResult mvcResult = mockMvc.perform(
				post("/login")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(requestJson))
				.andExpect(status().isOk())
				.andReturn();
		
		String jwtToken = mvcResult.getResponse().getHeader(HttpHeaders.AUTHORIZATION);
		assertTrue(jwtToken.startsWith("Bearer "));
    }
}
