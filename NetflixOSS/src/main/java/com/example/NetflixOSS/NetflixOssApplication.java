package com.example.NetflixOSS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class NetflixOssApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetflixOssApplication.class, args);
	}

}
