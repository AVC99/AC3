package Business;

import java.util.ArrayList;

public class Mythic extends Pokemon{
    private int rarity;

    public Mythic(int id, String name, String description, int height, int weight, double captureRate, String sprite, ArrayList<String> types, int rarity) {
        super(id, name, description, height, weight, captureRate, sprite, types);
        this.rarity = rarity;
    }

    public int getRarity() {
        return rarity;
    }
    @Override
    public String getPokemonClass(){
        return "Mythic";
    }
}
