package com.huawei;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.huawei.domain.project.Project;
import com.huawei.domain.scenario.Node;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisApplicationTests {

	@Autowired
	RedisTemplate<String, Project> prjRedisTemplate;
	
	@Autowired
	RedisTemplate<String, Node> nodeRedisTemplate;
		
	@Test
	public void test() {
		prjRedisTemplate.opsForValue().set("prj1", new Project("prj1", "liudehua"));
		prjRedisTemplate.opsForValue().set("prj2", new Project("prj2", "zhangxueyou"));
		prjRedisTemplate.opsForValue().set("prj3", new Project("prj3", "guofucheng"));
		prjRedisTemplate.opsForValue().set("prj4", new Project("prj4", "liming"));
		Assert.assertEquals("liudehua", prjRedisTemplate.opsForValue().get("prj1").getName());
	}

}
