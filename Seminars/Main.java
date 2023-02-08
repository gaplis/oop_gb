package Seminars;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

import Seminars.units.*;
import Seminars.units.civilians.Farmer;
import Seminars.units.healers.Mage;
import Seminars.units.healers.Monk;
import Seminars.units.melees.Rogue;
import Seminars.units.melees.Spearman;
import Seminars.units.ranges.CrossbowMan;
import Seminars.units.ranges.Sniper;

public class Main {
    public static final int GANG_SIZE = 5;
    public static ArrayList<BaseHero> whiteSide;
    public static ArrayList<BaseHero> darkSide;

    public static void main(String[] args) {
        init();

        Scanner scanner = new Scanner(System.in);
        boolean win = true;
        while (win){
            win = ConsoleView.view();
            if (win) {
                ArrayList<BaseHero> units = new ArrayList<>();
                units.addAll(whiteSide);
                units.addAll(darkSide);
                Comparator<BaseHero> comparator = Comparator.comparing(BaseHero::getSpeed);
                units.sort(comparator);
                System.out.println("-------------------------------------");
                for (BaseHero hero : units) {
                    if (hero.getTeam() == whiteSide) {
                        System.out.println("Ходит персонаж -" + hero.getRole() + "- на светлой стороне.");
                        hero.step(whiteSide, darkSide);
                    } else {
                        System.out.println("Ходит персонаж -" + hero.getRole() + "- на тёмной стороне.");
                        hero.step(darkSide, whiteSide);
                    }
                    System.out.println("-------------------------------------");
                }
                scanner.nextLine();
            }
            
        }
    }

    private static void init(){
        whiteSide = new ArrayList<>();
        darkSide = new ArrayList<>();

        int x = 1;
        int y = 1;
        for (int i = 0; i < GANG_SIZE; i++) {
            switch (new Random().nextInt(4)) {
                case 0: whiteSide.add(new Farmer(whiteSide, x, y++, "White")); break;
                case 1: whiteSide.add(new Rogue(whiteSide, x, y++, "White")); break;
                case 2: whiteSide.add(new Sniper(whiteSide, x, y++, "White")); break;
                default: whiteSide.add(new Monk(whiteSide, x, y++, "White")); break;
            }
        }

        x = GANG_SIZE;
        y = 1;
        for (int i = 0; i < GANG_SIZE; i++) {
            switch (new Random().nextInt(4)) {
                case 0: darkSide.add(new Farmer(darkSide, x, y++, "Dark")); break;
                case 1: darkSide.add(new Spearman(darkSide, x, y++, "Dark")); break;
                case 2: darkSide.add(new CrossbowMan(darkSide, x, y++, "Dark")); break;
                default: darkSide.add(new Mage(darkSide, x, y++, "Dark")); break;
            }
        }
    }

    public static boolean checkDeathSide(ArrayList<BaseHero> side){
        for (int i = 0; i < GANG_SIZE; i++) {
            if (side.get(i).getStatus()) {
                return true;
            }
        }
        return false;
    }
}
