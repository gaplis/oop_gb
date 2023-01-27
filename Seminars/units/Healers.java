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

        if (min < 100) {
            if (heroList.get(minPersentHealthPerson).health + -this.damage[0] < heroList.get(minPersentHealthPerson).maxHealth){
                heroList.get(minPersentHealthPerson).health = heroList.get(minPersentHealthPerson).health + -this.damage[0];
                System.out.println("Лекарь -" + this.getRole() + "- по имени " + this.getName() 
                            + " лечит персонажа " + heroList.get(minPersentHealthPerson).getName() + " на " 
                            + -this.damage[0] + " единиц здоровья.");
            } else {
                heroList.get(minPersentHealthPerson).health = heroList.get(minPersentHealthPerson).maxHealth;
                System.out.println("Лекарь -" + this.getRole() + "- по имени " + this.getName() 
                            + " полностью вылечил персонажа " + heroList.get(minPersentHealthPerson).getName() + ".");
            }
        } else {
            System.out.println("Все персонажи здоровы, лекарю -" + this.getRole() + "- по имени " + this.getName() 
            + " некого лечить.");
        }
        
    }

    @Override
    public String getType() {
        return "Healer";
    }
}
