package Seminars.units;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import Seminars.Vector2;

public abstract class BaseHero implements BaseInterface{

    protected String role;
    protected int attack, defence, health, maxHealth, speed;
    protected int[] damage;
    protected ArrayList<BaseHero> teamList;
    protected boolean alive;
    private Vector2 position;

    public BaseHero(ArrayList<BaseHero> teamList, String role, int attack, int defence, int[] damage, int health, int speed, int x, int y, boolean alive) {
        this.teamList = teamList;
        this.role = role;
        this.attack = attack;
        this.defence = defence;
        this.damage = damage;
        this.maxHealth = health;
        this.health = maxHealth - new Random().nextInt(maxHealth);
        this.speed = speed;
        this.position = new Vector2(x, y);
        this.alive = alive;
    }

    @Override
    public String toString() {
        return " Role: " + role + ", Attack: " + attack + ", Defence: " + defence + ", Damage: " + Arrays.toString(damage) + ", Health: " + health + ", Speed: " +  speed;
    }

    @Override
    public String getInfo() {
        if (alive) {
            return role + " | HP: " + health + "/" + maxHealth + " | DAMAGE: " + attack;
        } else {
            return role + " | DEAD ";
        }
    }

    @Override
    public void step(ArrayList<BaseHero> friendList, ArrayList<BaseHero> enemyList) {

    }

    @Override
    public String getRole() {
        return role;
    }

    public double getHealth() {
        return (health / maxHealth) * 100;
    }

    public Vector2 getPosition() {
        return position;
    }

    @Override
    public boolean getStatus() {
        return alive;
    }

    public Vector2 getTarget(ArrayList<BaseHero> enemyList) {
        double distance = 100;
        int nearestEnemyPerson = 0;
        for (int i = 0; i < enemyList.size(); i++) {
            double temp = Math.sqrt(Math.pow(getPosition().x - enemyList.get(i).getPosition().x, 2) 
            + Math.pow(getPosition().y - enemyList.get(i).getPosition().y, 2));
            if (temp < distance && enemyList.get(i).alive) {
                distance = temp;
                nearestEnemyPerson = i;
               }
        }
        return new Vector2(distance, nearestEnemyPerson);
    }

    public void setPosition(double x, double y) {
        this.position = new Vector2(x, y);
    }

    public boolean getDamage(ArrayList<BaseHero> enemyList, int i){
        if (this.attack > enemyList.get(i).defence) {
            return true;
        } else {
            return false;
        }
    }
}
