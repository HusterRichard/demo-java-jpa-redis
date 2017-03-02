package com.huawei;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@EnableRedisRepositories(basePackages = "com.huawei.domain.scenario", redisTemplateRef = "scenarioRedisTemplate")
public class ScenarioConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.redis.scenario")
    JedisConnectionFactory scenarioJedisConFactory() {
        return new JedisConnectionFactory();
    }

    @Bean(name = "scenarioRedisTemplate")
    public RedisTemplate<String, Object> scenarioRedisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
        template.setConnectionFactory(scenarioJedisConFactory());
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new RedisObjectSerializer());
        return template;
    }


}
