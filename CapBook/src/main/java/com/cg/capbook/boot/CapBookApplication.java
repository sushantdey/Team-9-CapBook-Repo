package com.cg.capbook.boot;
import javax.annotation.Resource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import com.cg.capbook.services.StorageService;
@SpringBootApplication(scanBasePackages= {"com.cg.capbook"})
@EntityScan(basePackages="com.cg.capbook.beans")
@EnableJpaRepositories(basePackages="com.cg.capbook.daoservices")
@EnableWebMvc
public class CapBookApplication {
	@Resource
	StorageService storageService;
	public static void main(String[] args) {
		SpringApplication.run(CapBookApplication.class, args);
	}
}