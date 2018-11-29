package com.adtech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class AdtechFacilitateEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdtechFacilitateEurekaApplication.class, args);
    }
}
