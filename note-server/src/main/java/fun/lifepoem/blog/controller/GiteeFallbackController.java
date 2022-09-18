package fun.lifepoem.blog.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author Yiwyn
 * @create 2022/9/18 14:49
 */
@Slf4j
@RestController
@RequestMapping("/gitee")
public class GiteeFallbackController {


    @PostMapping("/pushFallback")
    public void giteePushFallback(HttpServletRequest request, @RequestBody Map payload) {
        log.info("回调信息request:{}, requestBody:{}", request, payload);
    }

}
