package fun.lifepoem.blog.domain;

import fun.lifepoem.blog.common.GiteeUnitType;
import lombok.Data;
import lombok.ToString;
import org.springframework.beans.BeanUtils;
import org.springframework.cglib.beans.BeanMap;

import java.io.Serializable;
import java.util.Map;

/**
 * @author Yiwyn
 * @create 2022/9/12 22:46
 */
@Data
@ToString
public class GiteeUnit implements Serializable {

    private String type;
    private String encoding;
    private String name;
    private String path;
    private String content;
    private String sha;
    private String url;
    private String htmlUrl;
    private String downloadUrl;

    private static final long serialVersionUID = 42L;

    /**
     * 将map形同字段转换为实体类
     *
     * @param param
     * @return
     */
    public static GiteeUnit BuilderFromMap(Map param) {
        param.put("htmlUrl", param.get("html_url"));
        param.put("downloadUrl", param.get("download_url"));

        GiteeUnit giteeUnit = new GiteeUnit();
        BeanMap beanMap = BeanMap.create(giteeUnit);
        beanMap.putAll(param);
        return giteeUnit;
    }

    /**
     * 对name进行处理，gitee取到的name默认是需要后缀的，所以这里对后缀进行剔除
     *
     * @return
     */
    public String getName() {
        if (null != null && name.contains(GiteeUnitType.MD.getTypeName())) {
            String[] nameSplits = name.split("\\.");
            if (nameSplits.length > 1) {
                return nameSplits[0];
            }
        }
        return name;
    }
}
