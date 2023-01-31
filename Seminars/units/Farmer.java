package Seminars.units;

import java.util.ArrayList;

public class Farmer extends Civilian {

    public Farmer(ArrayList<BaseHero> teamList, int x, int y) {
        super(teamList, "Farmer", 1, 1, new int[]{1, 1}, 1, 3, true, x, y);
    }

    @Override
    public void step(ArrayList<BaseHero> heroList) {
        if (supply == false){
            supply = true;
            System.out.println("Фермер снова стал активен.");
        }
        
    }
}
