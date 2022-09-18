package fun.lifepoem.blog.service;

import fun.lifepoem.blog.domain.Article;
import fun.lifepoem.blog.domain.ArticleTag;
import fun.lifepoem.blog.domain.Tag;
import fun.lifepoem.blog.mapper.ArticleMapper;
import fun.lifepoem.blog.mapper.ArticleTagMapper;
import fun.lifepoem.blog.mapper.TagMapper;
import fun.lifepoem.blog.utils.SnowFlakeUtils;
import fun.lifepoem.blog.utils.localfile.LocalFileUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Yiwyn
 * @create 2022/9/18 0:48
 */
@Service
@Slf4j
public class GeneraterService {

    @Autowired
    private LocalFileUtils localFileUtils;


    @Autowired
    private TagMapper tagMapper;

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private ArticleTagMapper articleTagMapper;


    public void genderData() throws IOException {
        List<File> rootDir = localFileUtils.getRootDir();
        for (File file : rootDir) {
            generateArticleAndTag(file);
        }
    }

    /**
     * 递归生成，当前文件夹为tag名字，文件夹下文件都属于该tag；
     * 考虑优化项目，递归的同时保留上一层tag，对文章文件做多tag处理
     * @param file git仓库文件树下的文件/文件夹
     * @throws IOException
     */
    @Transactional(rollbackFor = Exception.class)
    public void generateArticleAndTag(File file) throws IOException {
        if (file == null) {
            log.info("接收file为空");
            return;
        }
        Date now = new Date();
        if (file.isFile()) {
            log.info("迭代到文件:{}无法继续迭代", file.getName());
            return;
        }

        //是路径，并且不是隐藏路径
        if (file.isDirectory() && !file.getName().contains(".")) {
            Tag tag = new Tag() {{
                setId(String.valueOf(SnowFlakeUtils.Instance().getSnowId()));
                setTagName(file.getName());
                setCreateTime(now);
                setDelFlag(false
                );
            }};

            File[] files = file.listFiles();

            if (ObjectUtils.isEmpty(files)) {
                return;
            }

            //本次操作的对象
            List<File> noteFiles = Arrays.stream(files).filter(File::isFile).collect(Collectors.toList());
            //继续迭代的对象，是路径但是不能是隐藏路径
            List<File> noteDir = Arrays.stream(files)
                    .filter(p -> p.isDirectory() && !p.getName().contains(".")).collect(Collectors.toList());
            //需要插入的文章
            List<Article> articles = new ArrayList<>();
            //需要插入的文章标签关系
            List<ArticleTag> articleTags = new ArrayList<>();

            FileInputStream fis = null;

            for (File noteFile : noteFiles) {

                StringBuffer content = new StringBuffer();
                byte[] bytes = new byte[1024];

                fis = new FileInputStream(noteFile);


                int len;
                while ((len = fis.read(bytes)) != -1) {
                    content.append(new String(bytes, 0, len));
                }

                //插入文章拼接
                Article article = new Article() {{
                    setId(String.valueOf(SnowFlakeUtils.Instance().getSnowId()));
                    setArticleName(noteFile.getName());
                    setArticleAuthor("Yiwyn");
                    setContent(content.toString());
                    setGitUrl(noteFile.getPath());
                    setCreateTime(now);
                    setDelFlag(false);
                }};
                articles.add(article);

                //关系拼接
                articleTags.add(new ArticleTag() {{
                    setId(String.valueOf(SnowFlakeUtils.Instance().getSnowId()));
                    setArticleId(article.getId());
                    setTagId(tag.getId());
                    setCreateTime(now);
                    setDelFlag(false);
                }});

            }
            if (fis != null) {
                fis.close();
            }

            int tagI = tagMapper.insert(tag);
            log.info("更新tag成功:{}", tag);

            if (!CollectionUtils.isEmpty(articles)) {
                int articleI = articleMapper.insertBatch(articles);
                log.info("更新article成功,影响行数:{}", articleI);
            }
            if (!CollectionUtils.isEmpty(articleTags)) {
                int articleTagI = articleTagMapper.insertBatch(articleTags);
                log.info("更新articleTag成功,影响行数:{}", articleTagI);
            }
            //进入递归生成
            for (File file1 : noteDir) {
                generateArticleAndTag(file1);
            }

        }
    }
}
