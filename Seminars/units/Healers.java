package Seminars.units;

import java.util.ArrayList;

public class Healers extends BaseHero {
    
    int mana;

    public Healers(String name, String role, int attack, int defence, int[] damage, int health, int speed, int mana) {
        super(name, role, attack, defence, damage, health, speed);
        this.mana = mana;
    }

    @Override
    public String toString() {
        return super.toString() + ", Mana: " + mana;
    }

    @Override
    public void step(ArrayList<BaseHero> heroList) {
        double min = 100; 
        int minPersentHealthPerson = 0;
        for (int i = 0; i < heroList.size(); i++) {
            String[] params = heroList.get(i).getInfo().split(" ");
            if (Integer.parseInt(params[1]) != Integer.parseInt(params[2])) {
               double temp = Double.parseDouble(params[2]) / Double.parseDouble(params[1]) * 100;
               if (temp < min) {
                min = temp;
                minPersentHealthPerson = i;
               }
            }
        }
        System.out.println("Лекарь -" + this.getRole() + "- по имени " + this.getName() + " лечит персонажа " + heroList.get(minPersentHealthPerson).getName());
    }

    @Override
    public String getType() {
        return "Healer";
    }
}
