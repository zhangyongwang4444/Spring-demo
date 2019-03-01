package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//  定义一个Spring程序的入口, Spring负责初始化Context
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        // 启动 Spring 框架 ，把控制权交给 Spring 框架
        SpringApplication.run(Application.class, args);

    }
}
