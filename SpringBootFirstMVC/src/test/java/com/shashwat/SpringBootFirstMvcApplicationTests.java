package com.shashwat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shashwat.SpringBootFirstMvcApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringBootFirstMvcApplication.class)
@WebAppConfiguration
public class SpringBootFirstMvcApplicationTests {

	@Test
	public void contextLoads() {
	}

}
