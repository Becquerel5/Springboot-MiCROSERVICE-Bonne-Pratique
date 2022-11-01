package org.gene.dtfbeurekaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DtfbEurekaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DtfbEurekaServiceApplication.class, args);
	}

}
