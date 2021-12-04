package Business;

import java.util.ArrayList;
import java.util.Map;

public class Mythic extends Pokemon {
    private final int rarity;

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
    @Override
    public Map<String, String> getAttributes() {
        Map<String, String> map= super.getAttributes() ;
        map.put("Rarity",String.valueOf(this.rarity));
        return map;
    }
}
