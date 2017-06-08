package com.may.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 将应用的main类放到root package下，就可以添加@ComponentScan注解而不添加任何参数，
 * 所有的应用组件（@Component,@Service,@Repository,@Controller）都会自动注解成spring beans
 */
@SpringBootApplication
public class DemoBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoBootApplication.class, args);
	}
}
