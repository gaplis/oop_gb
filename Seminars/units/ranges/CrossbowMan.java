package Seminars.units.ranges;

import java.util.ArrayList;

import Seminars.units.BaseHero;
import Seminars.units.Ranged;

public class CrossbowMan extends Ranged{
    public CrossbowMan(ArrayList<BaseHero> teamList, int x, int y) {
        super(teamList, "Crossbowman", 6, 3, new int[] {2, 3}, 10, 4, 16, x, y, true);
    }
}
