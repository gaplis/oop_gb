package Seminars.units;

import java.util.ArrayList;

public class Civilian extends BaseHero{

    protected boolean supply;

    public Civilian(String name, String role, int attack, int defence, int[] damage, int health, int speed, boolean supply) {
        super(name, role, attack, defence, damage, health, speed);
        this.supply = supply;
    }
    
    @Override
    public void step(ArrayList<BaseHero> heroList) {
        if (supply == false){
            supply = true;
            System.out.println("Фермер по имени " + this.getName() + " снова стал активен.");
        }
        
    }
    
    @Override
    public String toString() {
        if (supply) {
            return String.format("%s, Supply: Active", super.toString());
        } else {
            return String.format("%s, Supply: Passive", super.toString());
        }
        
    }

    @Override
    public String getType() {
        return "Civilian";
    }
}
