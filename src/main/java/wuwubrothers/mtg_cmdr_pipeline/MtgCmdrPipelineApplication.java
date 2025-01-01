package wuwubrothers.mtg_cmdr_pipeline;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import wuwubrothers.mtg_cmdr_pipeline.model.Card;
import wuwubrothers.mtg_cmdr_pipeline.service.MtgApiService;

import java.util.List;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class MtgCmdrPipelineApplication {

    public static void main(String[] args) {
        SpringApplication.run(MtgCmdrPipelineApplication.class, args);
    }

    @Bean
    CommandLineRunner run(MtgApiService mtgApiService) {
        return args -> {
            System.out.println("Fetching MTG cards...");
            List<Card> cards = mtgApiService.fetchAllMtgCards();

            // Print the number of cards fetched
            System.out.println("Fetched " + cards.size() + " cards!");

            // Print the first 5 cards for review
            cards.stream().limit(5).forEach(card -> System.out.println(card.getName() + " - " + card.getRarity()));
        };
    }

}