package fun.lifepoem.blog.mapper;

import fun.lifepoem.blog.domain.Article;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yiwyn
 * @description 针对表【article】的数据库操作Mapper
 * @createDate 2022-09-12 22:18:10
 * @Entity fun.lifepoem.blog.domain.Article
 */
@Repository
public interface ArticleMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Article record);

    int insertBatch(@Param("articles") List<Article> articles);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);

}
