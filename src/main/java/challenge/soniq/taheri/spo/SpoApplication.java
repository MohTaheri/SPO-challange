package challenge.soniq.taheri.spo;

import challenge.soniq.taheri.spo.services.OptimiseStaffs;
import challenge.soniq.taheri.spo.services.OptimiseStaffsFactory;
import challenge.soniq.taheri.spo.services.impl.OptimiseStaffsFactoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpoApplication.class, args);
	}

	@Bean
	public OptimiseStaffs optimiseStaffs() {
		return new OptimiseStaffsFactoryImpl().getOptimiser();
	}

}
