package com.example.spring01;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
// junit 4 버전으로 테스트
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(
locations= {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})

public class MainControllerTest {
	@Inject
	WebApplicationContext wac;
	MockMvc mockMvc;
	@Before //junit
	public void setup() throws Exception {
		mockMvc=MockMvcBuilders.webAppContextSetup(wac).build();
	}
	@Test
	public void testMain() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/doA"));
	}

	@Test
	public void testGugu() {
	}

	@Test
	public void testTest() {
	}

	@Test
	public void testDoA() {
	}

	@Test
	public void testDoB() {
	}

	@Test
	public void testDoC() {
	}

	@Test
	public void testDoD() {
	}

	@Test
	public void testDoE() {
	}

}
