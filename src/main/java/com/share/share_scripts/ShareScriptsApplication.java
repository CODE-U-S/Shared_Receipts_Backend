package com.share.share_scripts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ShareScriptsApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShareScriptsApplication.class, args);
    }
}