package Seminars.units.civilians;

import java.util.ArrayList;

import Seminars.units.BaseHero;
import Seminars.units.Civilian;

public class Farmer extends Civilian {

    public Farmer(ArrayList<BaseHero> teamList, int x, int y) {
        super(teamList, "Farmer", 1, 1, new int[]{1, 1}, 1, 3, true, x, y, true);
    }

    @Override
    public void step(ArrayList<BaseHero> friendList, ArrayList<BaseHero> enemyList) {
        if (alive) {
            if (supply == false){
                supply = true;
                System.out.println("Фермер снова стал активен.");
            } else {
                System.out.println("Фермер всё еще активен.");
            }
        } else {
            System.out.println("Фермер мертв, действий не выполняет.");
        }
        
    }
}
