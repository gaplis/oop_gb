package Seminars.units;

import java.util.ArrayList;

public class Melee extends BaseHero {
    public Melee(ArrayList<BaseHero> teamList, String role, int attack, int defence, int[] damage, int health, int speed, int x, int y) {
        super(teamList, role, attack, defence, damage, health, speed, x, y);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public String getType() {
        return "Melee";
    }
}
