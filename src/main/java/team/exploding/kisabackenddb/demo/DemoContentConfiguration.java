package team.exploding.kisabackenddb.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import team.exploding.kisabackenddb.model.*;
import team.exploding.kisabackenddb.service.*;

import java.util.List;

@Configuration
public class DemoContentConfiguration {
    @Bean
    CommandLineRunner commandLineRunner(KUserRepository kuserRepository,
                                        STRConstantRepository strConstantRepository,
                                        MRCSentenceRepository mrcSentenceRepository,
                                        MRCAnswerableRepository mrcAnswerableRepository,
                                        AttemptRepository attemptRepository) {
        return args -> {
            var kuserId = kuserRepository.save(KUser.builder().firstName("Enrico").build()).getId();
            attemptRepository.save(Attempt.builder()
                    .closed(false).user(kuserRepository.getById(kuserId)).build());

            var mrcSentence = MRCSentence.builder().build();
            mrcSentenceRepository.save(mrcSentence);
            var str = STRConstant.builder().string("test").mrcSentence(mrcSentence).build();
            strConstantRepository.save(str);
            var mrc = MRCAnswerable.builder().position(0).mrcSentence(mrcSentence).build();
            mrcAnswerableRepository.save(mrc);
        };
    }
}