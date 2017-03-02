package com.huawei;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@EnableRedisRepositories(basePackages = "com.huawei.domain.project", redisTemplateRef = "prjRedisTemplate")
public class ProjectConfig {

	@Primary
    @Bean
    @ConfigurationProperties(prefix = "spring.redis.project")
    JedisConnectionFactory prjJedisConFactory() {
        return new JedisConnectionFactory();
    }

	@Primary
    @Bean(name = "prjRedisTemplate")
    public RedisTemplate<String, Object> prjRedisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
        template.setConnectionFactory(prjJedisConFactory());
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new RedisObjectSerializer());
        return template;
    }


}
