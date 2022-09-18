package fun.lifepoem.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("fun.lifepoem.blog.mapper")
public class LifepoemBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(LifepoemBlogApplication.class, args);
    }

}
