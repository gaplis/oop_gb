package Seminars.units;

import java.util.ArrayList;

public class Healer extends BaseHero {
    
    int mana;

    public Healer(ArrayList<BaseHero> teamList, String role, int attack, int defence, int[] damage, int health, int speed, int mana, int x, int y, boolean alive) {
        super(teamList, role, attack, defence, damage, health, speed, x, y, alive);
        this.mana = mana;
    }

    @Override
    public String toString() {
        if (alive) {
            return super.toString() + ", Mana: " + mana;
        } else {
            return super.toString();
        }
    }

    @Override
    public void step(ArrayList<BaseHero> friendList, ArrayList<BaseHero> enemyList) {
        if (alive) {
            double min = 100; 
            int minPersentHealthPerson = 0;
            for (int i = 0; i < friendList.size(); i++) {
                if (friendList.get(i).alive) {
                    if (friendList.get(i).health != friendList.get(i).maxHealth) {
                       double temp = friendList.get(i).health * 100 / friendList.get(i).maxHealth;
                       if (temp < min) {
                        min = temp;
                        minPersentHealthPerson = i;
                       }
                    }
                }
            }
    
            if (min < 100) {
                if (friendList.get(minPersentHealthPerson).health + -this.damage[0] < friendList.get(minPersentHealthPerson).maxHealth){
                    friendList.get(minPersentHealthPerson).health = friendList.get(minPersentHealthPerson).health + -this.damage[0];
                    System.out.println("Лекарь -" + this.getRole() + 
                     "- лечит персонажа " + friendList.get(minPersentHealthPerson).getRole() + " на " 
                                + -this.damage[0] + " единиц здоровья.");
                } else {
                    friendList.get(minPersentHealthPerson).health = friendList.get(minPersentHealthPerson).maxHealth;
                    System.out.println("Лекарь -" + this.getRole() + 
                    "- полностью вылечил персонажа " + friendList.get(minPersentHealthPerson).getRole() + ".");
                }
            } else {
                System.out.println("Все персонажи здоровы, лекарю -" + this.getRole() + "- некого лечить.");
            }
        } else {
            System.out.println("Лекарь -" + this.getRole() + "- мертв, действий не выполняет.");
        }
    }

    @Override
    public String getType() {
        return "Healer";
    }
}
