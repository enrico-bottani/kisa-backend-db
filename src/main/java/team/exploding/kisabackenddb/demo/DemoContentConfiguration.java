package team.exploding.kisabackenddb.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import team.exploding.kisabackenddb.model.*;
import team.exploding.kisabackenddb.model.assignables.mrc.MRCAnswerable;
import team.exploding.kisabackenddb.model.assignables.mrc.MRCAnswerableItem;
import team.exploding.kisabackenddb.model.assignables.constant.STRConstant;
import team.exploding.kisabackenddb.model.exercise.Exercise;
import team.exploding.kisabackenddb.model.sentence.MRCSentence;
import team.exploding.kisabackenddb.repository.*;
import team.exploding.kisabackenddb.service.KisaUserDetailsService;

@Configuration

public class DemoContentConfiguration {
    @Bean
    CommandLineRunner commandLineRunner(KUserRepository kuserRepository,
                                        ExerciseRepository exerciseRepository,
                                        STRConstantRepository strConstantRepository,
                                        MRCSentenceRepository mrcSentenceRepository,
                                        MRCAnswerableRepository mrcAnswerableRepository,
                                        MRCAnswerableItemRepository mrcAnswerableItemRepository,
                                        MRCChoosenItemRepository mrcChoosenItemRepository,
                                        KisaUserDetailsService kisaUserDetailsService,
                                        AttemptRepository attemptRepository) {
        return args -> {
            kisaUserDetailsService.saveUsername("Enrico","Password");

            var kuser = KUser.builder().firstName("Enrico").build();
            kuserRepository.save(kuser);
            var attempt = Attempt.builder().closed(false).user(kuser).build();
            attemptRepository.save(attempt);

            var exercise = Exercise.builder().title("Put in the correct preposition").build();
            exerciseRepository.save(exercise);

            var mrcSentence = MRCSentence.builder().exercise(exercise).build();
            mrcSentence = mrcSentenceRepository.save(mrcSentence);

            var mrcSentence2 = MRCSentence.builder().exercise(exercise).build();
            mrcSentence2 = mrcSentenceRepository.save(mrcSentence2);

            var str = STRConstant.builder().string("test").mrcSentence(mrcSentence).build();
            strConstantRepository.save(str);
            var mrc = MRCAnswerable.builder().position(1).mrcSentence(mrcSentence).build();
            mrcAnswerableRepository.save(mrc);
            var mrcAI_to = MRCAnswerableItem.builder().choice("to").mrcAnswerable(mrc).build();
            var mrcAI_be = MRCAnswerableItem.builder().choice("be").mrcAnswerable(mrc).build();
            mrcAnswerableItemRepository.save(mrcAI_be);
            mrcAnswerableItemRepository.save(mrcAI_to);
            var choosenAnswer = MRCChoosenItem.builder().mrcAnswerableItem(mrcAI_be).attempt(attempt).build();
            mrcChoosenItemRepository.save(choosenAnswer);
            choosenAnswer = MRCChoosenItem.builder().mrcAnswerableItem(mrcAI_to).attempt(attempt).build();
            mrcChoosenItemRepository.save(choosenAnswer);
        };
    }
}
