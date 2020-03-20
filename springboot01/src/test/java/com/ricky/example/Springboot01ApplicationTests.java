package com.ricky.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


	@Test
	public void testMethod_1(){
		Map<String,Object> map = new HashMap<>();
		List<String> list = Arrays.asList("a","b");
		map.put("A","A-1");
		map.put("B",22);
		map.put("C",list);
		System.out.println(map.toString());

	}



}
