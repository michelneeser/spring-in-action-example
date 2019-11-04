package com.michelneeser.tacos;

import com.michelneeser.tacos.data.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class TacoCloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(TacoCloudApplication.class, args);
        Ingredient d = new Ingredient("asd", "asdf", Ingredient.Type.CHEESE);
    }

    @Bean
    @Profile("!prod")
    public CommandLineRunner makeDefaultUser(UserRepository userRepo, PasswordEncoder encoder) {
        return args -> {
            User user = new User("michel", encoder.encode("test"), "Michel Neeser", "Teststr.", "Testcity",
                    "AG", "1000", "0999999999");
            userRepo.save(user);
        };
    }

}