package Seminars;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import Seminars.units.BaseHero;
import Seminars.units.CrossbowMan;
import Seminars.units.Farmer;
import Seminars.units.Mage;
import Seminars.units.Monk;
import Seminars.units.Rogue;
import Seminars.units.Sniper;
import Seminars.units.Spearman;

public class Main {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        ArrayList<BaseHero> teamOne = new ArrayList<>();
        ArrayList<BaseHero> teamTwo = new ArrayList<>();
        Random random = new Random();
        generateHeroes(teamOne, 10, random, 1);
        generateHeroes(teamTwo, 10, random, 2);
        boolean start = true;
        while (start) {
            if (iScanner.next() == "q") {
                start = false;
            } else {
                teamOne.forEach(n -> System.out.print(n.toString() + "\n"));
                System.out.println("--------------");
                teamOne.forEach(n -> n.step(teamOne));
                System.out.println("--------------");
            }
        }
        iScanner.close();
    }

    private static void generateHeroes(ArrayList<BaseHero> heroesList, int count, Random rand, int team) {
        String[] namesList = {"Артём", "Александр", "Михаил", "Максим", "Иван", "Даниил", "Дмитрий", "Кирилл", "Никита", "Егор", "Матвей", "Андрей", "Илья", "Алексей", "Роман", "Сергей", "Владислав", "Ярослав", "Тимофей", "Арсений", "Денис", "Владимир", "Павел", "Глеб", "Константин", "Богдан", "Евгений", "Николай", "Степан", "Захар", "Тимур", "Марк", "Семён", "Фёдор", "Георгий", "Лев", "Антон", "Вадим", "Игорь", "Руслан", "Вячеслав", "Григорий", "Макар", "Артур", "Виктор", "Станислав", "Савелий", "Олег", "Давид", "Леонид", "Пётр", "Юрий", "Виталий", "Мирон", "Василий", "Всеволод", "Елисей", "Назар", "Родион", "Марат",
                "Платон", "Герман", "Игнат", "Святослав", "Анатолий", "Тихон", "Валерий", "Мирослав", "Ростислав", "Борис", "Филипп", "Демьян", "Гордей", "Валентин", "Демид", "Прохор", "Серафим", "Савва", "Яромир",
                "Аркадий", "Архип", "Тарас", "Трофим"};
        int namesSize = namesList.length;

        int farmersCount = 0;
        for (int i = 0; i < count; i++){
            int role = rand.nextInt(4);
            
            if (team == 1) {
                switch (role){
                    case 0 -> farmersCount++; //heroesList.add(new Farmer(namesList[rand.nextInt(namesSize)]));
                    case 1 -> heroesList.add(new Mage(namesList[rand.nextInt(namesSize)]));
                    case 2 -> heroesList.add(new Rogue(namesList[rand.nextInt(namesSize)]));
                    case 3 -> heroesList.add(new Sniper(namesList[rand.nextInt(namesSize)]));
                }
            } else {
                switch (role){
                    case 0 -> farmersCount++; //heroesList.add(new Farmer(namesList[rand.nextInt(namesSize)]));
                    case 1 -> heroesList.add(new CrossbowMan(namesList[rand.nextInt(namesSize)]));
                    case 2 -> heroesList.add(new Monk(namesList[rand.nextInt(namesSize)]));
                    case 3 -> heroesList.add(new Spearman(namesList[rand.nextInt(namesSize)]));
                }
            }
        }
        for (int i = 0; i < farmersCount; i++) {
            heroesList.add(new Farmer(namesList[rand.nextInt(namesSize)]));
        }
    }
}
