package Seminars.units;

import java.util.ArrayList;

public class Monk extends Healers{
    public Monk(ArrayList<BaseHero> teamList, int x, int y){
        super(teamList, "Monk", 12, 7, new int[] {-4, -4}, 30, 5, 1, x, y);
    }
}
