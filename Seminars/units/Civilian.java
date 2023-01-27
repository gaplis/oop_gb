package Seminars.units;

public class Civilian extends BaseHero{

    protected boolean supply;

    public Civilian(String name, String role, int attack, int defence, int[] damage, int health, int speed, boolean supply) {
        super(name, role, attack, defence, damage, health, speed);
        this.supply = supply;
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
