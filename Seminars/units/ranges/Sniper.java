package Seminars.units.ranges;

import java.util.ArrayList;

import Seminars.units.BaseHero;
import Seminars.units.Ranged;

public class Sniper extends Ranged{
    public Sniper(ArrayList<BaseHero> teamList, int x, int y) {
        super(teamList, "Sniper", 12, 10, new int[]{8, 10}, 15, 9, 32, x, y, true);
    }
}
