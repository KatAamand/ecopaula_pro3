package org.ecopaula.station1_registration;

import dto.AnimalDTO;
import org.ecopaula.station1_registration.rabbitMQ.Station1Producer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Station1RegistrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(Station1RegistrationApplication.class, args);
    }

}
