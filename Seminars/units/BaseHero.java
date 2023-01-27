package Seminars.units;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public abstract class BaseHero implements BaseInterface{

    protected String name, role;
    protected int attack, defence, health, maxHealth, speed;
    protected int[] damage;

    public BaseHero(String name, String role, int attack, int defence, int[] damage, int health, int speed) {
        this.name = name;
        this.role = role;
        this.attack = attack;
        this.defence = defence;
        this.damage = damage;
        this.maxHealth = health;
        this.health = maxHealth - new Random().nextInt(maxHealth);
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Role: " + role + ", Attack: " + attack + ", Defence: " + defence + ", Damage: " + Arrays.toString(damage) + ", Health: " + health + ", Speed: " +  speed;
    }

    @Override
    public String getInfo() {
        return role + " " + String.valueOf(maxHealth) + " " + String.valueOf(health) ;
    }

    @Override
    public void step(ArrayList<BaseHero> heroList) {

    }

    @Override
    public String getRole() {
        return role;
    }

    @Override
    public String getName() {
        return name;
    }

    public double getHealth() {
        return (health / maxHealth) * 100;
    }

}