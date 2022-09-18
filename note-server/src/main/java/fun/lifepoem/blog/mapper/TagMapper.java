package fun.lifepoem.blog.mapper;

import fun.lifepoem.blog.domain.Tag;
import fun.lifepoem.blog.domain.bo.TagAllBO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yiwyn
 * @description 针对表【tag】的数据库操作Mapper
 * @createDate 2022-09-12 21:15:44
 * @Entity fun.lifepoem.blog.domain.Tag
 */
@Repository
public interface TagMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Tag record);

    int insertSelective(Tag record);

    List<TagAllBO> selectAllTag();

    int insertBatch(@Param("records") List<Tag> records);

    Tag selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Tag record);

    int updateByPrimaryKey(Tag record);

}
