package com.tausif.todoz;

//import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.tausif.todoz.TodozApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
		classes=TodozApplication.class
		)
@AutoConfigureMockMvc
@TestPropertySource(locations="classpath:application.properties")
public class TodoTaskControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	private boolean executeSetup=true;
	
	private String jwtToken=null;
	
	@Before
	public void setUp() throws Exception 
	{
		if(!executeSetup)
		{
			return;
		}
		
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
		
		jwtToken = mvcResult.getResponse().getHeader(HttpHeaders.AUTHORIZATION);
		
		if(jwtToken!=null && jwtToken.length()>0)
		{
			executeSetup=false;	
		}
	}
	
	@Test
    public void testCreateTodoTask() throws Exception 
    {
		String randStr = String.valueOf(Math.random());
		String requestJson="{" + 
				"	\"detail\":\"todotask"+randStr+"\"," + 
				"    \"priority\":\"1\"," + 
				"    \"taskStartTime\":\"\"," + 
				"    \"taskEndTime\":\"\"," + 
				"    \"notifyBeforeMinute\":\"\"," + 
				"    \"todoTaskStatus\":\"NEW\"" + 
				"}";
		MvcResult mvcResult = mockMvc.perform(
				post("/private/todotask")
				.header(HttpHeaders.AUTHORIZATION, jwtToken)
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(requestJson))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.*", hasSize(13)))
				.andExpect(jsonPath("$.id", is(notNullValue())))
				.andReturn();
    }
	
	@Test
    public void testGetTodoTask() throws Exception
    {
		String randStr = String.valueOf(Math.random());
		String requestJson="{" + 
				"	\"detail\":\"todotask"+randStr+"\"," + 
				"    \"priority\":\"1\"," + 
				"    \"taskStartTime\":\"\"," + 
				"    \"taskEndTime\":\"\"," + 
				"    \"notifyBeforeMinute\":\"\"," + 
				"    \"todoTaskStatus\":\"NEW\"" + 
				"}";
		MvcResult createdTaskMvcResult=mockMvc.perform(
				post("/private/todotask")
				.header(HttpHeaders.AUTHORIZATION, jwtToken)
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(requestJson))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.*", hasSize(13)))
				.andExpect(jsonPath("$.id", is(notNullValue())))
				.andReturn();
		
		JSONObject json=new JSONObject(createdTaskMvcResult.getResponse().getContentAsString());
		
		mockMvc.perform(
					get("/private/todotask/"+json.getString("id"))
					.header(HttpHeaders.AUTHORIZATION, jwtToken)
					.accept(MediaType.APPLICATION_JSON)
					.contentType(MediaType.APPLICATION_JSON)
				)
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.*", hasSize(13)))
				.andExpect(jsonPath("$.id", is(json.getInt("id"))));
		
    }
	
	@Test
    public void testGetAllTodoTask() throws Exception
    {
		String randStr = String.valueOf(Math.random());
		String requestJson="{" + 
				"	\"detail\":\"todotask"+randStr+"\"," + 
				"    \"priority\":\"1\"," + 
				"    \"taskStartTime\":\"\"," + 
				"    \"taskEndTime\":\"\"," + 
				"    \"notifyBeforeMinute\":\"\"," + 
				"    \"todoTaskStatus\":\"NEW\"" + 
				"}";
		MvcResult createdTaskMvcResult=mockMvc.perform(
				post("/private/todotask")
				.accept(MediaType.APPLICATION_JSON)
				.header(HttpHeaders.AUTHORIZATION, jwtToken)
				.contentType(MediaType.APPLICATION_JSON)
				.content(requestJson))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.*", hasSize(13)))
				.andExpect(jsonPath("$.id", is(notNullValue())))
				.andReturn();
		JSONObject json=new JSONObject(createdTaskMvcResult.getResponse().getContentAsString());
		mockMvc.perform(
				get("/private/todotask")
				.header(HttpHeaders.AUTHORIZATION, jwtToken)
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
			)
			.andExpect(status().isOk());
	}
	
	@Test
    public void testDeleteTodoTask() throws Exception
    {
		String randStr = String.valueOf(Math.random());
		String requestJson="{" + 
				"	\"detail\":\"todotask"+randStr+"\"," + 
				"    \"priority\":\"1\"," + 
				"    \"taskStartTime\":\"\"," + 
				"    \"taskEndTime\":\"\"," + 
				"    \"notifyBeforeMinute\":\"\"," + 
				"    \"todoTaskStatus\":\"NEW\"" + 
				"}";
		MvcResult createdTaskMvcResult=mockMvc.perform(
				post("/private/todotask")
				.header(HttpHeaders.AUTHORIZATION, jwtToken)
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(requestJson))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.*", hasSize(13)))
				.andExpect(jsonPath("$.id", is(notNullValue())))
				.andReturn();
		JSONObject json=new JSONObject(createdTaskMvcResult.getResponse().getContentAsString());
		mockMvc.perform(
				delete("/private/todotask/"+json.getString("id"))
				.header(HttpHeaders.AUTHORIZATION, jwtToken)
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
			)
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.*", hasSize(13)))
			.andExpect(jsonPath("$.id", is(json.getInt("id"))));
	}

}
