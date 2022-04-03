package team.exploding.kisabackenddb.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import team.exploding.kisabackenddb.model.exercise.Exercise;
import team.exploding.kisabackenddb.model.sentence.RadioGroup;
import team.exploding.kisabackenddb.model.sentence.RadioItem;
import team.exploding.kisabackenddb.model.sentence.Sentence;
import team.exploding.kisabackenddb.model.series.Series;
import team.exploding.kisabackenddb.repository.*;
import team.exploding.kisabackenddb.service.KisaUserDetailsService;

import java.util.List;

@Configuration

public class DemoContentConfiguration {
    @Bean
    CommandLineRunner commandLineRunner(SeriesRepository seriesRepository,
                                        ExerciseRepository exerciseRepository,
                                        KisaUserDetailsService kisaUserDetailsService,
                                        SentenceRepository sentenceRepository,
                                        RadioGroupRepository radioGroupRepository,
                                        RadioItemRepository radioItemRepository
    ) {
        return args -> {
            var user = kisaUserDetailsService.saveUsername("Enrico", "Password");
            var sue = kisaUserDetailsService.saveUsername("Sue", "Password");

           /* var kuser = KUser.builder().firstName("Enrico").build();
            kuserRepository.save(kuser);
            var attempt = Attempt.builder().closed(false).user(kuser).build();
            attemptRepository.save(attempt);*/

            var series = Series.builder().title("Series 1").author(user).build();
            seriesRepository.save(series);
            var exercise = Exercise.builder().title("Put in the correct preposition")
                    .series(series).build();
            exerciseRepository.save(exercise);

            var sentence = sentenceRepository.save(Sentence.builder()
                    .exercise(exercise)
                    .strings(List.of("Put", "the correct preposition")).build());
            var radioGroup = radioGroupRepository.save(RadioGroup.builder().sentence(sentence).build());
            var radioItem = radioItemRepository.save(RadioItem.builder().value("on").radios(radioGroup).build());
            var radioItem2 = radioItemRepository.save(RadioItem.builder().correct(true).value("in").radios(radioGroup).build());

            var sentence2 = sentenceRepository.save(Sentence.builder()
                    .exercise(exercise)
                    .strings(List.of("Anne is arriving", "seven o'clock.")).build());
            var radioGroup2 = radioGroupRepository.save(RadioGroup.builder().sentence(sentence2).build());
            var radioItem21 = radioItemRepository.save(RadioItem.builder()
                    .value("at").correct(true).radios(radioGroup2).build());
            var radioItem22 = radioItemRepository.save(RadioItem.builder()
                    .value("on").radios(radioGroup2).build());

           /* var choosenAnswer = MRCChoosenItem.builder().mrcAnswerableItem(mrcAI_be).attempt(attempt).build();
            mrcChoosenItemRepository.save(choosenAnswer);
            choosenAnswer = MRCChoosenItem.builder().mrcAnswerableItem(mrcAI_to).attempt(attempt).build();
            mrcChoosenItemRepository.save(choosenAnswer);*/
        };
    }
}
