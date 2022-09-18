package fun.lifepoem.blog.service;

import fun.lifepoem.blog.common.GiteeUnitType;
import fun.lifepoem.blog.domain.GiteeUnit;
import fun.lifepoem.blog.domain.Tag;
import fun.lifepoem.blog.mapper.TagMapper;
import fun.lifepoem.blog.utils.SnowFlakeUtils;
import fun.lifepoem.blog.utils.gitee.GiteeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Yiwyn
 * @create 2022/9/15 23:45
 */
@Service
@Slf4j
public class TagService {

    @Autowired
    private GiteeUtils giteeUtils;

    @Autowired
    private TagMapper tagMapper;

    public void generateTagsByGitee() {
        List<GiteeUnit> giteeUnits = giteeUtils.getGiteeUnits("/");

        List<GiteeUnit> giteeDirs = giteeUnits.stream()
                .filter(p -> GiteeUnitType.DIR.getTypeName().equals(p.getType())).collect(Collectors.toList());

        Date now = new Date();

        List<Tag> tags = giteeDirs.stream().map(p -> new Tag() {{
            setId(String.valueOf(SnowFlakeUtils.Instance().getSnowId()));
            setTagName(p.getName());
            setCreateTime(now);
            setDelFlag(false);
        }}).collect(Collectors.toList());

        int i = tagMapper.insertBatch(tags);
        log.info("更新tag成功,effect row:{}", i);
    }


}
