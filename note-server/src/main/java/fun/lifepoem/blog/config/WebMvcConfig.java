package fun.lifepoem.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Yiwyn
 * @create 2022/9/12 22:26
 */
@Configuration
public class WebMvcConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
