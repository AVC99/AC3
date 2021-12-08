package Business;

import java.util.ArrayList;
import java.util.Map;

public class Legendary extends Pokemon{
    private final int power;

    public Legendary(int id, String name, String description, int height, int weight, double captureRate, String sprite, ArrayList<String> types, int power) {
        super(id, name, description, height, weight, captureRate, sprite, types);
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    @Override
    public boolean capture(int random) {
        double div=(1 - ((double)this.getPower() / 1440));
        double result=( this.getCaptureRate()/1.5) * div ;
        if (random + 1 <= result) {
            return true;
        }
        return false;
    }

    @Override
    public Map<String, String> getAttributes() {
        Map<String, String> map= super.getAttributes();
        map.put("Power",String.valueOf(this.power));
        return map;
    }
}
