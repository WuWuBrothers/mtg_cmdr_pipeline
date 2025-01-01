package wuwubrothers.mtg_cmdr_pipeline.model;

import java.util.List;

public class MtgCardResponse {
    private List<Card> cards;

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}
