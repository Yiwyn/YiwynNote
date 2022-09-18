package fun.lifepoem.blog.mapper;

import fun.lifepoem.blog.domain.ArticleTag;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 55971
 * @description 针对表【article_tag】的数据库操作Mapper
 * @createDate 2022-09-17 22:04:44
 * @Entity fun.lifepoem.blog.domain.ArticleTag
 */
@Repository
public interface ArticleTagMapper {

    int deleteByPrimaryKey(Long id);

    int insert(ArticleTag record);

    int insertBatch(@Param("articleTags") List<ArticleTag> articleTags);

    int insertSelective(ArticleTag record);

    ArticleTag selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ArticleTag record);

    int updateByPrimaryKey(ArticleTag record);

}
