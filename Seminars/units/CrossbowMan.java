package Seminars.units;

import java.util.ArrayList;

public class CrossbowMan extends Ranged{
    public CrossbowMan(ArrayList<BaseHero> teamList, int x, int y) {
        super(teamList, "Crossbowman", 6, 3, new int[] {2, 3}, 10, 4, 16, x, y);
    }
}
