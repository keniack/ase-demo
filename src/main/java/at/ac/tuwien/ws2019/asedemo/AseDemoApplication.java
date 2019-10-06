package at.ac.tuwien.ws2019.asedemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AseDemoApplication {

	static Logger log = LoggerFactory.getLogger(AseDemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AseDemoApplication.class, args);
		log.info("Application Started");

	}

}
