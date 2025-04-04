package org.keyin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan
@EnableJpaRepositories
public class Main {
    public static void main(String[] args) {
        System.out.println("Binary Search Tree - DSA Final Sprint");
        SpringApplication.run(Main.class, args);
    }
}