package fun.lifepoem.blog.utils.gitee;

import fun.lifepoem.blog.domain.GiteeUnit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Yiwyn
 * @create 2022/9/12 22:27
 */
@Component
@Slf4j
public class GiteeUtils {

    @Autowired
    RestTemplate restTemplate;

    @Value("${gitee.base-url}")
    private String baseUrl;

    @Value("${gitee.base_download_url}")
    private String downloadUrl;


    public List<GiteeUnit> getGiteeUnits(String path) {
        String url = baseUrl + path;
        log.info("查询url:{}", url);

        ResponseEntity<List> giteeUnitsEntity = null;
        try {
            giteeUnitsEntity = restTemplate.getForEntity(url, List.class);
        } catch (Exception e) {
            log.error("访问出现错误:{}", e.getMessage());
        }

        if (ObjectUtils.isEmpty(giteeUnitsEntity)) {
            return null;
        }

        List<Map> body = giteeUnitsEntity.getBody();

        if (ObjectUtils.isEmpty(body)) {
            return null;
        }
        List<GiteeUnit> giteeUnits = body.stream().map(GiteeUnit::BuilderFromMap).collect(Collectors.toList());
        return giteeUnits;
    }


}
