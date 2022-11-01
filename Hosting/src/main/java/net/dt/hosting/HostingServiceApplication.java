package net.dt.hosting;

import net.dt.hosting.dto.HostingRequestDTO;
import net.dt.hosting.services.HostingService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class HostingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HostingServiceApplication.class, args);
	}
/*
	@Bean
	CommandLineRunner start(HostingService hostingService){
		return  args -> {
			hostingService.save(new HostingRequestDTO());

		};
	}

 */
}
