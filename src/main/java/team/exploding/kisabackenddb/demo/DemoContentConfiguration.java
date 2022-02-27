package team.exploding.kisabackenddb.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import team.exploding.kisabackenddb.model.*;
import team.exploding.kisabackenddb.model.assignables.mrc.MRCAnswerable;
import team.exploding.kisabackenddb.model.assignables.mrc.MRCAnswerableItem;
import team.exploding.kisabackenddb.model.assignables.STRConstant;
import team.exploding.kisabackenddb.repository.*;

@Configuration

public class DemoContentConfiguration {
    @Bean
    CommandLineRunner commandLineRunner(KUserRepository kuserRepository,
                                        STRConstantRepository strConstantRepository,
                                        MRCSentenceRepository mrcSentenceRepository,
                                        MRCAnswerableRepository mrcAnswerableRepository,
                                        MRCAnswerableItemRepository mrcAnswerableItemRepository,
                                        AttemptRepository attemptRepository) {
        return args -> {
            var kuser = KUser.builder().firstName("Enrico").build();
            kuserRepository.save(kuser);
            var attempt = Attempt.builder().closed(false).user(kuser).build();
            attemptRepository.save(attempt);

            var mrcSentence = MRCSentence.builder().build();
            mrcSentence = mrcSentenceRepository.save(mrcSentence);
            var str = STRConstant.builder().string("test").mrcSentence(mrcSentence).build();
            strConstantRepository.save(str);
            var mrc = MRCAnswerable.builder().position(0).mrcSentence(mrcSentence).build();
            mrcAnswerableRepository.save(mrc);
            var mrcAI_to = MRCAnswerableItem.builder().choice("to").mrcAnswerable(mrc).build();
            var mrcAI_be = MRCAnswerableItem.builder().choice("be").mrcAnswerable(mrc).build();
            mrcAnswerableItemRepository.save(mrcAI_be);
            mrcAnswerableItemRepository.save(mrcAI_to);
        };
    }
}