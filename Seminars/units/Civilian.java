package Seminars.units;

import java.util.ArrayList;

public class Civilian extends BaseHero{
    protected boolean supply;

    public Civilian(ArrayList<BaseHero> teamList, String role, int attack, int defence, int[] damage, int health, int speed, boolean supply, int x, int y, boolean alive, String team) {
        super(teamList, role, attack, defence, damage, health, speed, x, y, alive, team);
        this.supply = supply;
    }
    
    @Override
    public String toString() {
        if (alive) {
            if (supply) {
                return String.format("%s, Supply: Active", super.toString());
            } else {
                return String.format("%s, Supply: Passive", super.toString());
            }
        } else {
            return super.toString();
        }
        
    }

    @Override
    public String getType() {
        return "Civilian";
    }
}
