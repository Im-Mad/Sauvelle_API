package ma.sauvelle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"ma.sauvelle"})
public class SauvelleApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SauvelleApiApplication.class, args);
    }

}
