package Seminars.units;

import java.util.ArrayList;

import Seminars.units.civilians.Farmer;

public class Ranged extends BaseHero {

    int shoots;

    public Ranged(ArrayList<BaseHero> teamList, String role, int attack, int defence, int[] damage, int health, int speed, int shoots, int x, int y, boolean alive, String team) {
        super(teamList, role, attack, defence, damage, health, speed, x, y, alive, team);
        this.shoots = shoots;
    }

    @Override
    public String toString() {
        if (alive) {
            return super.toString() + ", Shoots: " + shoots;
        } else {
            return super.toString();
        }
    }

    @Override
    public void step(ArrayList<BaseHero> friendList, ArrayList<BaseHero> enemyList) {
        if (alive) {
            if (shoots != 0) {
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

                    if (getDamage(enemyList, nearEnemy)) {
                        attackPower = damage[1];
                    } else {
                        attackPower = damage[0];
                    }
                    
                    if(enemyList.get(nearEnemy).health - attackPower <= 0) {
                        enemyList.get(nearEnemy).health = 0;
                        enemyList.get(nearEnemy).alive = false;
                        System.out.println("Боец -" + this.getRole() + "- делает один выстрел по противнику -" + 
                        enemyList.get(nearEnemy).getRole() + "- и убивает его.");
                    } else {
                        enemyList.get(nearEnemy).health -= attackPower;
                        System.out.println("Боец -" + this.getRole() + "- делает один выстрел по противнику -" + 
                        enemyList.get(nearEnemy).getRole() + "- и наносит ему " + 
                        attackPower + " единиц урона.");
                    }
                    shoots--;
                } else {
                    System.out.println("Вражеская команда мертва, стрелять не по кому.");
                }
            } else {
                System.out.println("У бойца -" + this.getRole() + "- нет стрел.");
            }
    
            for (int i = 0; i < friendList.size(); i++) {
                if(friendList.get(i).getRole().equals("Farmer")) {
                    if (((Farmer)friendList.get(i)).alive) {
                        if(((Farmer)friendList.get(i)).supply == true){
                            shoots++;
                            ((Farmer)friendList.get(i)).supply = false;
                            System.out.println("Фермер возвращает бойцу -" + this.getRole() 
                            + "- одну стрелу и становится неактивен.");
                            break; // чтобы только один фермер принёс стрелу обратно одному лучнику, а то без прерываний все фермеры будут нести,
                            // а следующим лучникам фермера не достанется)
                        } else {
                            System.out.println("Фермер был не активен, потому не принёс стрелу обратно.");
                        }
                    } else {
                        System.out.println("Фермер мертв, действий не выполняет.");
                    }
                }
            }
    
            System.out.println("Оставшееся количество выстрелов: " + shoots);
        } else {
            System.out.println("Боец -" + this.getRole() + "- мертв, действий не выполняет.");
        }
    }

    @Override
    public String getType() {
        return "Ranged";
    }

    @Override
    public String getInfo() {
        if (alive) {
            return super.getInfo() + " | ARROWS: " + shoots;
        } else {
            return super.getInfo();
        }
    }
}
