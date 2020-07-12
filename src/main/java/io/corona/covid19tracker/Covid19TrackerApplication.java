package io.corona.covid19tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "io.corona.covid19tracker.repository")
@SpringBootApplication
public class Covid19TrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Covid19TrackerApplication.class, args);
	}

}
