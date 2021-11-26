package Business;

import java.util.ArrayList;

public class Pokemon {
    private int id;
    private String name;
    private String description;
    private int height;
    private int weight;
    private double captureRate;
    private String sprite;
    private ArrayList<String> types;

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
}
