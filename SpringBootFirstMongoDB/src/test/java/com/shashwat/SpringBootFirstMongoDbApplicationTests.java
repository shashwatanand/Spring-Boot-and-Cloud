package com.shashwat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shashwat.SpringBootFirstMongoDbApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringBootFirstMongoDbApplication.class)
@WebAppConfiguration
public class SpringBootFirstMongoDbApplicationTests {

	@Test
	public void contextLoads() {
	}

}
