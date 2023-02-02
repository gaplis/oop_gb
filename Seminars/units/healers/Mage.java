package Seminars.units.healers;

import java.util.ArrayList;

import Seminars.units.BaseHero;
import Seminars.units.Healer;

public class Mage extends Healer {

    public Mage(ArrayList<BaseHero> teamList, int x, int y){
        super(teamList, "Mage", 17, 12, new int[] {-5, -5}, 30, 9, 1, x, y, true);
    }
    
}
