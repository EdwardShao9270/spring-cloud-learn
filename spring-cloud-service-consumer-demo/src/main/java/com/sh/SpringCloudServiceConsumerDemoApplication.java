package com.sh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bjshaohang
 */
@SpringBootApplication(scanBasePackages = {"com.sh"})
@EnableDiscoveryClient
@EnableFeignClients
@RestController
public class SpringCloudServiceConsumerDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudServiceConsumerDemoApplication.class, args);
	}
}
