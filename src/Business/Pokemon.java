package Business;

import java.util.ArrayList;

public class Pokemon implements Comparable<Pokemon> {
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
    public String getName() {
        return name;
    }
    public double getCaptureRate() {
        return captureRate;
    }
    public int getId(){
        return id;
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
        if (random+1 <= this.getCaptureRate()/1.5){
            return true;
        }
        return false;
    }
    public int getPower() {
        return 1;
    }
}
