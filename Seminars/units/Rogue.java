package Seminars.units;

import java.util.ArrayList;

public class Rogue extends Melee {
    public Rogue(ArrayList<BaseHero> teamList, int x, int y) {
        super(teamList, "Rogue", 8, 3, new int[] {2, 4}, 10, 6, x, y);
    }
}
