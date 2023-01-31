package Seminars.units;

import java.util.ArrayList;

public class Sniper extends Ranged{
    public Sniper(ArrayList<BaseHero> teamList, int x, int y) {
        super(teamList, "Sniper", 12, 10, new int[]{8, 10}, 15, 9, 32, x, y);
    }
}
