package Business;

import java.util.ArrayList;

public class Legendary extends Pokemon{
    private int power;

    public Legendary(int id, String name, String description, int height, int weight, double captureRate, String sprite, ArrayList<String> types, int power) {
        super(id, name, description, height, weight, captureRate, sprite, types);
        this.power = power;
    }
}
