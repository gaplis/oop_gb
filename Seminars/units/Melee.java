package Seminars.units;

public class Melee extends BaseHero {
    public Melee(String name, String role, int attack, int defence, int[] damage, int health, int speed) {
        super(name, role, attack, defence, damage, health, speed);
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
