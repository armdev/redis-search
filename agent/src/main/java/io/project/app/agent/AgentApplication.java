package io.project.app.agent;

import io.project.app.domain.SearchData;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication
@ComponentScan("io.project")
@EnableRedisRepositories("io.project.app.repositories")
@EntityScan("io.project.app.domain")
public class AgentApplication {

    public static void main(String[] args) {
        final SpringApplication application = new SpringApplication(AgentApplication.class);
        application.setBannerMode(Banner.Mode.CONSOLE);
        application.setWebApplicationType(WebApplicationType.REACTIVE);
        application.run(args);
    }

    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory jedisConFactory
                = new JedisConnectionFactory();
        jedisConFactory.setHostName("redis");
        jedisConFactory.setPort(6379);
        jedisConFactory.setPassword("jroot");
        return jedisConFactory;
    }

    @Bean
    public RedisTemplate<String, SearchData> redisTemplate() {
        RedisTemplate<String, SearchData> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        return template;
    }

}
