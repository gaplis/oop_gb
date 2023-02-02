package Seminars.units;

import java.util.ArrayList;

public class Melee extends BaseHero {
    public Melee(ArrayList<BaseHero> teamList, String role, int attack, int defence, int[] damage, int health, int speed, int x, int y, boolean alive) {
        super(teamList, role, attack, defence, damage, health, speed, x, y, alive);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public String getType() {
        return "Melee";
    }

    @Override
    public void step(ArrayList<BaseHero> friendList, ArrayList<BaseHero> enemyList) {
        if (alive) {
            System.out.println("Боец -" + this.getRole() + "- пока что не выполняет действий. ЗАГЛУШКА");
        } else {
            System.out.println("Боец -" + this.getRole() + "- мертв, действий не выполняет.");
        }
    }
}
