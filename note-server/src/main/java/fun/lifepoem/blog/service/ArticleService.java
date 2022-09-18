package fun.lifepoem.blog.service;

import fun.lifepoem.blog.common.GiteeUnitType;
import fun.lifepoem.blog.domain.Article;
import fun.lifepoem.blog.domain.ArticleTag;
import fun.lifepoem.blog.domain.GiteeUnit;
import fun.lifepoem.blog.domain.bo.TagAllBO;
import fun.lifepoem.blog.mapper.ArticleMapper;
import fun.lifepoem.blog.mapper.ArticleTagMapper;
import fun.lifepoem.blog.mapper.TagMapper;
import fun.lifepoem.blog.utils.SnowFlakeUtils;
import fun.lifepoem.blog.utils.gitee.GiteeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Yiwyn
 * @create 2022/9/17 21:04
 */
@Service
@Slf4j
public class ArticleService {
    @Autowired
    private GiteeUtils giteeUtils;

    @Autowired
    private TagMapper tagMapper;

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private ArticleTagMapper articleTagMapper;

    @Transactional(rollbackFor = Exception.class)
    public void gengerateArticleByGitee() {

        List<TagAllBO> tags = tagMapper.selectAllTag();

        Date now = new Date();

        for (TagAllBO tag : tags) {
            List<GiteeUnit> giteeUnits = giteeUtils.getGiteeUnits(tag.getTagName());
            //标签下为空直接跳过
            if (CollectionUtils.isEmpty(giteeUnits)) {
                break;
            }
            List<GiteeUnit> articles = giteeUnits.stream()
                    .filter(p -> GiteeUnitType.FILE.getTypeName().equals(p.getType()))
                    .collect(Collectors.toList());


            //需要插入的文章
            List<Article> articleList = articles.stream().map(p -> new Article() {{
                setId(String.valueOf(SnowFlakeUtils.Instance().getSnowId()));
                setArticleName(p.getName());
                setArticleAuthor("Yiwyn");
                setContent(p.getContent());
                setGitUrl(p.getDownloadUrl());
                setCreateTime(now);
                setDelFlag(false);
            }}).collect(Collectors.toList());

            //需要插入的文章标签关系
            List<String> articleIds = articleList.stream().map(Article::getId).collect(Collectors.toList());
            List<ArticleTag> articleTags = articleIds.stream().map(p -> new ArticleTag() {{
                setId(String.valueOf(SnowFlakeUtils.Instance().getSnowId()));
                setArticleId(p);
                setTagId(tag.getId());
                setCreateTime(now);
                setDelFlag(false);
            }}).collect(Collectors.toList());

            int articleIresult = articleMapper.insertBatch(articleList);
            int articleTagIresult = articleTagMapper.insertBatch(articleTags);

            log.info("article 更新成功,effect row:{}", articleIresult);
            log.info("articleTag 更新成功,effect row:{}", articleTagIresult);

        }
    }
}
