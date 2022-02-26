package team.exploding.kisabackenddb.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import team.exploding.kisabackenddb.model.*;
import team.exploding.kisabackenddb.service.AttemptRepository;
import team.exploding.kisabackenddb.service.KUserRepository;
import team.exploding.kisabackenddb.service.MRCSentenceRepository;
import team.exploding.kisabackenddb.service.STRConstantRepository;

import java.util.List;

@Configuration
public class DemoContentConfiguration {
    @Bean
    CommandLineRunner commandLineRunner(KUserRepository kuserRepository,
                                        STRConstantRepository strConstantRepository,
                                        MRCSentenceRepository mrcSentenceRepository,
                                        AttemptRepository attemptRepository) {
        return args -> {
            var kuserId = kuserRepository.save(KUser.builder().firstName("Enrico").build()).getId();
            attemptRepository.save(Attempt.builder()
                    .closed(false).user(kuserRepository.getById(kuserId)).build());

            var mrcSentence = MRCSentence.builder().build();
            mrcSentenceRepository.save(mrcSentence);
            var str = STRConstant.builder().string("test").mrcSentence(mrcSentence).build();
            strConstantRepository.save(str);
        };
    }
}