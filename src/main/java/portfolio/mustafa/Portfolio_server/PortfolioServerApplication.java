package portfolio.mustafa.Portfolio_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class PortfolioServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortfolioServerApplication.class, args);
	}

}
