package com.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 由配置文件可以查询到 swagger 界面的访问地址
 * <a href="http://localhost:8080/swagger-ui.html">...</a>
 */
@SpringBootApplication
public class SwaggerKnife4jApplication {

    public static void main(String[] args) {
        SpringApplication.run(SwaggerKnife4jApplication.class, args);
    }

}
