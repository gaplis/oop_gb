package Seminars;

import java.util.ArrayList;
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
            System.out.println("-------------------------------------");
            whiteSide.forEach(n -> n.step(whiteSide, darkSide));
            System.out.println("-------------------------------------");
            darkSide.forEach(n -> n.step(darkSide, whiteSide));
            System.out.println("-------------------------------------");
            scanner.nextLine();
        }
    }

    private static void init(){
        whiteSide = new ArrayList<>();
        darkSide = new ArrayList<>();

        int x = 1;
        int y = 1;
        int countWhiteFarmer = 0;
        int countDarkFarmer = 0;
        for (int i = 0; i < GANG_SIZE; i++) {
            switch (new Random().nextInt(4)) {
                case 0: countWhiteFarmer++; break; // whiteSide.add(new Farmer(whiteSide, x, y++)); 
                case 1: whiteSide.add(new Rogue(whiteSide, x, y++)); break;
                case 2: whiteSide.add(new Sniper(whiteSide, x, y++)); break;
                default: whiteSide.add(new Monk(whiteSide, x, y++)); break;
            }
        }
        
        for (int i = 0; i < countWhiteFarmer; i++) {
            whiteSide.add(new Farmer(whiteSide, x, y++));
        }

        x = GANG_SIZE;
        y = 1;
        for (int i = 0; i < GANG_SIZE; i++) {

            switch (new Random().nextInt(4)) {
                case 0: countDarkFarmer++; break; // darkSide.add(new Farmer(darkSide, x, y++)); break;
                case 1: darkSide.add(new Spearman(darkSide, x, y++)); break;
                case 2: darkSide.add(new CrossbowMan(darkSide, x, y++)); break;
                default: darkSide.add(new Mage(darkSide, x, y++)); break;
            }
        }

        for (int i = 0; i < countDarkFarmer; i++) {
            darkSide.add(new Farmer(darkSide, x, y++));
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
