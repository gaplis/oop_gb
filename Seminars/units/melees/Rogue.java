package Seminars.units.melees;

import java.util.ArrayList;

import Seminars.units.BaseHero;
import Seminars.units.Melee;

public class Rogue extends Melee {
    public Rogue(ArrayList<BaseHero> teamList, int x, int y) {
        super(teamList, "Rogue", 8, 3, new int[] {2, 4}, 10, 6, x, y, true);
    }
}
