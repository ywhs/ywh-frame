package com.ywh.core;

import com.ywh.core.dao.ExampleDao;
import com.ywh.core.entity.ExampleEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoreApplicationTests {

	@Autowired
	private ExampleDao exampleDao;

	@Test
	public void contextLoads() {
		List<ExampleEntity> all = exampleDao.findAll();
		System.out.println(all);
	}

}

