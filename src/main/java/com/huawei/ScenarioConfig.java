package com.didispace;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.*;

@Configuration
@EnableRedisRepository(basepackages = "com.huawei.domain.scenario", redisTemplateRef = "scenarioRedisTemplate")
public class ScenarioConfig {

	@Primary
    @Bean
    JedisConnectionFactory scenarioJedisConFactory() {
        return new JedisConnectionFactory();
    }

	@Primary
    @Bean(name = "scenarioRedisTemplate")
    public RedisTemplate<String, Object> scenarioRedisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
        template.setConnectionFactory(scenarioJedisConFactory());
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new RedisObjectSerializer());
        return template;
    }


}
