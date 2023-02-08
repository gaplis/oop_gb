package Seminars.units;

import java.util.ArrayList;
import java.util.Random;

import Seminars.units.civilians.Farmer;
import Seminars.units.healers.Mage;
import Seminars.units.healers.Monk;
import Seminars.units.melees.Rogue;
import Seminars.units.melees.Spearman;
import Seminars.units.ranges.CrossbowMan;
import Seminars.units.ranges.Sniper;

public class Healer extends BaseHero {
    
    int mana;

    public Healer(ArrayList<BaseHero> teamList, String role, int attack, int defence, int[] damage, int health, int speed, int mana, int x, int y, boolean alive, String team) {
        super(teamList, role, attack, defence, damage, health, speed, x, y, alive, team);
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
            int deathPerson = 0;
            boolean deathHero = false;
            for (int i = 0; i < friendList.size(); i++) {
                if (friendList.get(i).alive) {
                    if (friendList.get(i).health != friendList.get(i).maxHealth) {
                       double temp = friendList.get(i).health * 100 / friendList.get(i).maxHealth;
                       if (temp < min) {
                        min = temp;
                        minPersentHealthPerson = i;
                       }
                    }
                } else {
                    deathHero = true;
                    deathPerson = i;
                    break;
                }
            }
    
            if (!deathHero) {
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
                String previousRole = friendList.get(deathPerson).getRole();
                int posX = (int) friendList.get(deathPerson).getPosition().x;
                int posY = (int) friendList.get(deathPerson).getPosition().y;
                if (friendList.get(deathPerson).team == "White") {
                    switch (new Random().nextInt(4)) {
                        case 0: friendList.set(deathPerson, new Farmer(friendList, posX, posY, "White")); break;
                        case 1: friendList.set(deathPerson ,new Rogue(friendList, posX, posY, "White")); break;
                        case 2: friendList.set(deathPerson, new Sniper(friendList, posX, posY, "White")); break;
                        default: friendList.set(deathPerson, new Monk(friendList, posX, posY, "White")); break;
                    }
                } else {
                    switch (new Random().nextInt(4)) {
                        case 0: friendList.set(deathPerson, new Farmer(friendList, posX, posY, "Dark")); break;
                        case 1: friendList.set(deathPerson, new Spearman(friendList, posX, posY, "Dark")); break;
                        case 2: friendList.set(deathPerson, new CrossbowMan(friendList, posX, posY, "Dark")); break;
                        default: friendList.set(deathPerson, new Mage(friendList, posX, posY, "Dark")); break;
                    }
                }
                System.out.println("Лекарь -" + this.getRole() + 
                        "- воскресил персонажа " + previousRole + " и этот персонаж теперь " + friendList.get(deathPerson).getRole() + ".");
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
