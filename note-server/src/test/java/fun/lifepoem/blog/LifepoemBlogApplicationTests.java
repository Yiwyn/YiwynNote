package fun.lifepoem.blog;

import fun.lifepoem.blog.service.ArticleService;
import fun.lifepoem.blog.service.GeneraterService;
import fun.lifepoem.blog.service.TagService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class LifepoemBlogApplicationTests {

    @Autowired
    private TagService tagService;

    @Autowired
    private ArticleService articleService;


    @Autowired
    private GeneraterService generaterService;

    @Test
    void contextLoads() {
        tagService.generateTagsByGitee();
    }

    @Test
    void generateArticle() {
        articleService.gengerateArticleByGitee();
    }

    @Test
    void testGenerateData() throws IOException {
        generaterService.genderData();
    }

}

