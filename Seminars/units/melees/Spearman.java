package Seminars.units.melees;

import java.util.ArrayList;

import Seminars.units.BaseHero;
import Seminars.units.Melee;

public class Spearman extends Melee{
    public Spearman(ArrayList<BaseHero> teamList, int x, int y) {
        super(teamList, "Spearman", 4, 5, new int [] {1, 3}, 10, 4, x, y, true);
    }
}
