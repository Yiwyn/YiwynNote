package fun.lifepoem.blog.utils.localfile;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Yiwyn
 * @create 2022/9/17 23:04
 */
@Component
@Slf4j
public class LocalFileUtils {


    @Value("${note.file-locations}")
    private String noteLocation;


    /**
     * 文件夹处理
     */
    public File getRootFile() {
        File file = new File(noteLocation);

        File[] files = file.listFiles();

        if (ObjectUtils.isEmpty(files)) {
            log.info("本地文件列表为空");
            return null;
        }

        return file;
    }

    public List<File> getRootDir() {
        File file = new File(noteLocation);

        File[] files = file.listFiles();

        if (ObjectUtils.isEmpty(files)) {
            log.info("本地文件列表为空");
            return null;
        }
        List<File> fileList = Arrays.stream(files)
                .filter(p -> p.isDirectory() && !p.getName().contains("."))
                .collect(Collectors.toList());


        return fileList;
    }


}
