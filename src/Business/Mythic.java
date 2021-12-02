package Business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Mythic extends Pokemon {
    private int rarity;

    public Mythic(int id, String name, String description, int height, int weight, double captureRate, String sprite, ArrayList<String> types, int rarity) {
        super(id, name, description, height, weight, captureRate, sprite, types);
        this.rarity = rarity;
    }

    public int getRarity() {
        return rarity;
    }



    public boolean capture(int random) {

        if (random + 1 >= Math.pow(2,this.getCaptureRate()/1.5)*(this.getRarity()/this.getCaptureRate())) {
            return true;
        }

        return false;
    }
    public Map<String, String> getAttributes() {
        Map<String, String> map= new HashMap<String, String >();
        map.put("Capture rate",String.valueOf(this.getCaptureRate()));
        map.put("Height",(double)this.getHeight()/10+" m");
        map.put("Weight",(double)this.getWeight()/10+" kg");
        map.put("Rarity",String.valueOf(this.rarity));
        return map;
    }
}
