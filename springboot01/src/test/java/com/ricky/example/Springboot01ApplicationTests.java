package com.ricky.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class Springboot01ApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void contextLoads() throws Exception {
		/*MvcResult mvcResult= mockMvc.perform(MockMvcRequestBuilders.get("/getUserMethod"))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
		int status = mvcResult.getResponse().getStatus();
		System.out.println(status);*/
	}



}