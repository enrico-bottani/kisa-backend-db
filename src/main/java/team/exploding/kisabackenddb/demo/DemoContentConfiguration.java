package team.exploding.kisabackenddb.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import team.exploding.kisabackenddb.model.Attempt;
import team.exploding.kisabackenddb.model.KUser;
import team.exploding.kisabackenddb.service.AttemptRepository;
import team.exploding.kisabackenddb.service.KUserRepository;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DemoContentConfiguration {
    @Bean
    CommandLineRunner commandLineRunner(KUserRepository kuserRepository, AttemptRepository attemptRepository) {
        return args -> {
            var kuserId = kuserRepository.save(KUser.builder().firstName("Enrico").build()).getId();
            attemptRepository.save(Attempt.builder().closed(false).user(kuserRepository.getById(kuserId)).build());
        };
    }
}