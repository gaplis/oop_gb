package Seminars.units;

import java.util.ArrayList;

public class Healers extends BaseHero {
    
    int mana;

    public Healers(ArrayList<BaseHero> teamList, String role, int attack, int defence, int[] damage, int health, int speed, int mana, int x, int y) {
        super(teamList, role, attack, defence, damage, health, speed, x, y);
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
            if (heroList.get(i).health != heroList.get(i).maxHealth) {
               double temp = heroList.get(i).health / heroList.get(i).maxHealth * 100;
               if (temp < min) {
                min = temp;
                minPersentHealthPerson = i;
               }
            }
        }

        if (min < 100) {
            if (heroList.get(minPersentHealthPerson).health + -this.damage[0] < heroList.get(minPersentHealthPerson).maxHealth){
                heroList.get(minPersentHealthPerson).health = heroList.get(minPersentHealthPerson).health + -this.damage[0];
                System.out.println("Лекарь -" + this.getRole() + 
                 "- лечит персонажа " + heroList.get(minPersentHealthPerson).getRole() + " на " 
                            + -this.damage[0] + " единиц здоровья.");
            } else {
                heroList.get(minPersentHealthPerson).health = heroList.get(minPersentHealthPerson).maxHealth;
                System.out.println("Лекарь -" + this.getRole() + 
                "- полностью вылечил персонажа " + heroList.get(minPersentHealthPerson).getRole() + ".");
            }
        } else {
            System.out.println("Все персонажи здоровы, лекарю -" + this.getRole() + "- некого лечить.");
        }
        
    }

    @Override
    public String getType() {
        return "Healer";
    }
}
