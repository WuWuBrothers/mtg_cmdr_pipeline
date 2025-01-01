package wuwubrothers.mtg_cmdr_pipeline.model;


/*
    Design the Entity for MTG API
    id
    name
    manaCost
    type
    rarity
    text
 */

public class Card {
    private String id;
    private String name;
    private String manaCost;

    private String type;
    private String rarity;
    private String text;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManaCost() {
        return manaCost;
    }

    public void setManaCost(String manaCost) {
        this.manaCost = manaCost;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", manaCost='" + manaCost + '\'' +
                ", type='" + type + '\'' +
                ", rarity='" + rarity + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
