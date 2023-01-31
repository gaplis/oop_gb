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
    private Vector2 position;

    public BaseHero(ArrayList<BaseHero> teamList, String role, int attack, int defence, int[] damage, int health, int speed, int x, int y) {
        this.teamList = teamList;
        this.role = role;
        this.attack = attack;
        this.defence = defence;
        this.damage = damage;
        this.maxHealth = health;
        this.health = maxHealth - new Random().nextInt(maxHealth);
        this.speed = speed;
        this.position = new Vector2(x, y);
    }

    @Override
    public String toString() {
        return " Role: " + role + ", Attack: " + attack + ", Defence: " + defence + ", Damage: " + Arrays.toString(damage) + ", Health: " + health + ", Speed: " +  speed;
    }

    @Override
    public String getInfo() {
        return role + " | HP: " + health + "/" + maxHealth + " | DAMAGE: " + attack;
    }

    @Override
    public void step(ArrayList<BaseHero> heroList) {

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

}
