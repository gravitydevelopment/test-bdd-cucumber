package bdd;

import org.junit.runner.JUnitCore;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class TestRunner {
    public static void main (String[] args) {
        SpringApplication.run(TestRunner.class, args);
    }
}


