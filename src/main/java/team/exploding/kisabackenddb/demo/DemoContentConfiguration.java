package team.exploding.kisabackenddb.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import team.exploding.kisabackenddb.model.exercise.Exercise;
import team.exploding.kisabackenddb.model.sentence.Sentence;
import team.exploding.kisabackenddb.model.series.Series;
import team.exploding.kisabackenddb.repository.ExerciseRepository;
import team.exploding.kisabackenddb.repository.SentenceRepository;
import team.exploding.kisabackenddb.repository.SeriesRepository;
import team.exploding.kisabackenddb.service.KisaUserDetailsService;

import java.util.List;

@Configuration

public class DemoContentConfiguration {
    @Bean
    CommandLineRunner commandLineRunner(SeriesRepository seriesRepository,
                                        ExerciseRepository exerciseRepository,
                                        KisaUserDetailsService kisaUserDetailsService,
                                        SentenceRepository sentenceRepository
                                        ) {
        return args -> {
           var user = kisaUserDetailsService.saveUsername("Enrico","Password");
           var sue = kisaUserDetailsService.saveUsername("Sue","Password");

           /* var kuser = KUser.builder().firstName("Enrico").build();
            kuserRepository.save(kuser);
            var attempt = Attempt.builder().closed(false).user(kuser).build();
            attemptRepository.save(attempt);*/

            var series = Series.builder().title("Series 1").author(user).build();
            seriesRepository.save(series);
            var exercise = Exercise.builder().title("Put in the correct preposition")
                    .series(series).build();
            exerciseRepository.save(exercise);
            sentenceRepository.save(Sentence.builder().exercise(exercise).sentences(List.of("in","on")).build());

           /* var choosenAnswer = MRCChoosenItem.builder().mrcAnswerableItem(mrcAI_be).attempt(attempt).build();
            mrcChoosenItemRepository.save(choosenAnswer);
            choosenAnswer = MRCChoosenItem.builder().mrcAnswerableItem(mrcAI_to).attempt(attempt).build();
            mrcChoosenItemRepository.save(choosenAnswer);*/
        };
    }
}
