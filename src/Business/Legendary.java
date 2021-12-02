package Business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Legendary extends Pokemon{
    private int power;

    public Legendary(int id, String name, String description, int height, int weight, double captureRate, String sprite, ArrayList<String> types, int power) {
        super(id, name, description, height, weight, captureRate, sprite, types);
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public boolean capture(int random) {
        double div=(1 - ((double)this.getPower() / 1440));
        double result=( this.getCaptureRate()/1.5) *div ;
        if (random + 1 <= result) {
            return true;
        }
        return false;
    }

    public Map<String, String> getAttributes() {
        Map<String, String> map= new HashMap<String, String >();
        map.put("Capture rate",String.valueOf(this.getCaptureRate()));
        map.put("Height",(double)this.getHeight()/10+" m");
        map.put("Weight",(double)this.getWeight()/10+" kg");
        map.put("Power",String.valueOf(this.power));
        return map;
    }
}
