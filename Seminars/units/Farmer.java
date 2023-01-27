package Seminars.units;

import java.util.ArrayList;

public class Farmer extends Civilian {

    public Farmer(String name) {
        super(name, "Farmer", 1, 1, new int[]{1, 1}, 1, 3, true);
    }

    @Override
    public void step(ArrayList<BaseHero> heroList) {
        if (supply == false){
            supply = true;
            System.out.println("Фермер по имени " + this.getName() + " снова стал активен.");
        }
        
    }
}
