package Business;

import edu.salleurl.profile.Profileable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Pokemon implements Comparable<Pokemon>, Profileable {
    private final int id;
    private final String name;
    private final String description;
    private final int height;
    private final int weight;
    private final double captureRate;
    private final String sprite;
    private final ArrayList<String> types;

    public Pokemon(int id, String name, String description, int height, int weight, double captureRate, String sprite, ArrayList<String> types) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.height = height;
        this.weight = weight;
        this.captureRate = captureRate;
        this.sprite = sprite;
        this.types = types;
    }

    @Override
    public String getTitle() {
        return this.name+ " ("+this.id+")";
    }

    @Override
    public String getPictureUrl() {
        return this.sprite;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public Map<String, String> getAttributes() {
        Map<String, String> map= new HashMap<>();
        map.put("Capture rate",String.valueOf((int)this.captureRate));
        map.put("Height",(double)this.height/10+" m");
        map.put("Weight",(double)this.weight/10+" kg");
        return map;
    }

    @Override
   public String getMainColorHex() {
        return getHexCode(this.getTypes().get(0));
    }

    @Override
    public String getSecondaryColorHex() {
        if(this.getTypes().size()>1){
            return getHexCode(this.getTypes().get(1));
        }else return getHexCode(this.getTypes().get(0));

    }
    public ArrayList<String> getTypes() {
        return types;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public double getCaptureRate() {
        return captureRate;
    }

    @Override
    public int compareTo(Pokemon comparesto) {
        int compareage = comparesto.getId();
        return this.id - compareage;
    }
    public int getRarity() {
        return 0;
    }

    public boolean capture( int random){
        return random + 1 <= this.getCaptureRate() / 1.5;
    }
    public int getPower() {
        return 1;
    }

    private String getHexCode(String Type){
        return switch (Type) {
            case "normal" -> "#A8A878";
            case "fighting" -> "#C03028";
            case "flying" -> "#A890F0";
            case "poison" -> "#A040A0";
            case "ground" -> "#E0C068";
            case "rock" -> "#B8A038";
            case "bug" -> "#A8B820";
            case "ghost" -> "#705898";
            case "steel" -> "#B8B8D0";
            case "fire" -> "#F08030";
            case "water" -> "#6890F0";
            case "grass" -> "#78C850";
            case "electric" -> "#F8D030";
            case "psychic" -> "#F85888";
            case "ice" -> "#98D8D8";
            case "dragon" -> "#7038F8";
            case "dark" -> "#705848";
            case "fairy" -> "#EE99AC";
            case "???" -> "#68A090";
            default -> null;
        };
    }
}
