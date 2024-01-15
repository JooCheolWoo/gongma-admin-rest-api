package kr.co.gongma.gongma_admin_rest_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GongmaAdminRestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(GongmaAdminRestApiApplication.class, args);
    }

}
