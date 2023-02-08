package Seminars.units.healers;

import java.util.ArrayList;

import Seminars.units.BaseHero;
import Seminars.units.Healer;

public class Monk extends Healer{
    public Monk(ArrayList<BaseHero> teamList, int x, int y, String team){
        super(teamList, "Monk", 12, 7, new int[] {-4, -4}, 30, 5, 1, x, y, true, team);
    }
}
