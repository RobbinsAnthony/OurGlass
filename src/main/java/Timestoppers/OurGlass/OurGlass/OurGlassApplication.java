package Timestoppers.OurGlass.OurGlass;

import Timestoppers.OurGlass.OurGlass.timemap.models.TimeMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class OurGlassApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(OurGlassApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(OurGlassApplication.class, args);
	}



	@Override
	public void run(String... args) throws Exception {
		logger.info("container ready");
		RestTemplate restTemplate = new RestTemplate();
		String urlTimeZoner = "https://timezone.abstractapi.com/v1/current_time/?api_key=73df5937b4c24123bde19880d192d7a9&location=Oxford,%20United%20Kingdom";
		TimeMap data = restTemplate.getForObject(urlTimeZoner, TimeMap.class);
		logger.info(data.toString());


	}

}