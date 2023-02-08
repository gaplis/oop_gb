package Seminars.units;

import java.util.ArrayList;

import Seminars.Vector2;

public class Melee extends BaseHero {
    public Melee(ArrayList<BaseHero> teamList, String role, int attack, int defence, int[] damage, int health, int speed, int x, int y, boolean alive, String team) {
        super(teamList, role, attack, defence, damage, health, speed, x, y, alive, team);
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
            boolean aliveTeam = false;
            for (int i = 0; i < enemyList.size(); i++) {
            if (enemyList.get(i).alive) {
                    aliveTeam = true;
                    break;
                }
            }

            if (aliveTeam) {
                int nearEnemy = (int) getTarget(enemyList).y;
                int attackPower;

                Vector2 target = getTarget(enemyList);
                if (target.x == 100) {
                    return;
                }
                
                int targetX = (int) enemyList.get((int) target.y).getPosition().x;
                int targetY = (int) enemyList.get((int) target.y).getPosition().y;
                boolean targetLeft = targetX < getPosition().x;
                boolean targetRight = targetX > getPosition().x;
                boolean targetUp = targetY > getPosition().y;
                boolean targetDown = targetY < getPosition().y;
        
                if (target.x < 2) {
                    if (getDamage(enemyList, nearEnemy)) {
                        attackPower = damage[1];
                    } else {
                        attackPower = damage[0];
                    }
                    
                    if(enemyList.get(nearEnemy).health - attackPower <= 0) {
                        enemyList.get(nearEnemy).health = 0;
                        enemyList.get(nearEnemy).alive = false;
                        System.out.println("Боец -" + this.getRole() + "- делает один удар по противнику -" + 
                        enemyList.get(nearEnemy).getRole() + "- и убивает его.");
                    } else {
                        enemyList.get(nearEnemy).health -= attackPower;
                        System.out.println("Боец -" + this.getRole() + "- делает один удар по противнику -" + 
                        enemyList.get(nearEnemy).getRole() + "- и наносит ему " + 
                        attackPower + " единиц урона.");
                    }
                } else if (targetRight) {
                    setPosition(++getPosition().x, getPosition().y);
                    System.out.println("Боец -" + this.getRole() + "- делает шаг.");
                } else if (targetLeft) {
                    setPosition(--getPosition().x, getPosition().y);
                    System.out.println("Боец -" + this.getRole() + "- делает шаг.");
                } else if (targetX == getPosition().x) {
                    if (targetUp) {
                        setPosition(getPosition().x, ++getPosition().y);
                        System.out.println("Боец -" + this.getRole() + "- делает шаг.");
                    } else if (targetDown) {
                        setPosition(getPosition().x, --getPosition().y);
                        System.out.println("Боец -" + this.getRole() + "- делает шаг.");
                    }
                }
            } else {
                System.out.println("Вражеская команда мертва, наносить урон не по кому.");
            }
        } else {
            System.out.println("Боец -" + this.getRole() + "- мертв, действий не выполняет.");
        }
    }
}
