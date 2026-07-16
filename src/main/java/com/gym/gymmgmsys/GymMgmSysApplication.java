package com.gym.gymmgmsys;

import com.gym.gymmgmsys.common.config.JwtProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(JwtProperties.class)
public class GymMgmSysApplication {

    public static void main(String[] args) {
        SpringApplication.run(GymMgmSysApplication.class, args);
    }

}
