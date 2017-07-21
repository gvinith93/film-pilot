package io.egen.test.controller;

import java.util.Date;
import java.util.UUID;

import io.egen.controller.UserController;
import io.egen.entity.ShowDetails;
import io.egen.entity.UserComments;
import io.egen.entity.UserDetails;
import io.egen.service.UserCommentsService;
import io.egen.service.UserService;
import io.egen.test.TestConfig;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={TestConfig.class})
@WebAppConfiguration
public class UserControllerTest {

	@Mock
	UserService userservice;
	
	@InjectMocks
	UserController controller;
	
	private MockMvc mockMvc;
	private UserDetails user;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		user=new UserDetails();
		user.setEmailId("dummy@dummy.com");
		user.setFirstName("dummy");
		user.setLastName("user");
		user.setUserType("user");
		user.setPassword("abc12");
		user.setCreatedDate(new Date(2016-13-04));	
		mockMvc=MockMvcBuilders.standaloneSetup(controller).build();
	}
	
	@Test
	public void testCreateUser() throws Exception{
	
		mockMvc.perform(MockMvcRequestBuilders.post("/api/users/"))
				.andExpect(MockMvcResultMatchers.status().isOk());
		Mockito.verify(userservice).create(user);
	}
	
	
	
	
	
}
