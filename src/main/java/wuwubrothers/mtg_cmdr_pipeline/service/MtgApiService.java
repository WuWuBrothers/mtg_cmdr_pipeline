package wuwubrothers.mtg_cmdr_pipeline.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import wuwubrothers.mtg_cmdr_pipeline.model.Card;
import wuwubrothers.mtg_cmdr_pipeline.model.MtgCardResponse;

import java.util.ArrayList;
import java.util.List;

/*Use Spring’s RestTemplate to call the API and populate the MtgCard objects.

 */
@Service
public class MtgApiService {

    private final RestTemplate restTemplate;

    public MtgApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Card> fetchAllMtgCards() {
        String baseUrl = "https://api.magicthegathering.io/v1/cards";
        int page = 1; // Start with the first page
        int pageSize = 5; // Define the number of results per page
        List<Card> allCards = new ArrayList<>();

        while (page <= pageSize) {
            String paginatedUrl = UriComponentsBuilder.fromHttpUrl(baseUrl)
                    .queryParam("page", page)
                    .queryParam("pageSize", pageSize)
                    .toUriString();

            System.out.println("Page URL: " + paginatedUrl);

            MtgCardResponse response = restTemplate.getForObject(paginatedUrl, MtgCardResponse.class);

            if (response == null || response.getCards().isEmpty()) {
                break; // Exit loop if no more data is returned
            }

            allCards.addAll(response.getCards());
            page++; // Increment the page number for the next request
        }

        return allCards;
    }
}
