/* Написать программу с семью классами, описывающими данных в таблице персонажей. 
Для каждого создать по два конструктора	и геттеры приватных полей. 
А также метод возвращающий строку с кратким описанием персонажа. 
В основной программе создать списки с пятью экземплярами каждого персонажа и вывести информацию обо все в консоль. */

package Seminars.Seminar_1;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArrayList<BaseHero> heroes = new ArrayList<>();
        Random random = new Random();
        generateHeroes(heroes, 50, random);
        chooseHero(heroes, "Rogue");

        // ArrayList<BaseHero> farmers = new ArrayList<>();
        // String[] farmersNames = {"Михаил", "Иван", "Олег", "Денис", "Владислав"};
        // for (String name : farmersNames) {
        //     farmers.add(new Farmer(name));
        // }
        // for (BaseHero character : farmers){
        //     System.out.println(character);
        // }
        // System.out.println("==========================");

        // ArrayList<BaseHero> rouges = new ArrayList<>();
        // String[] rougesNames = {"Михаил", "Иван", "Олег", "Денис", "Владислав"};
        // for (String name : rougesNames) {
        //     rouges.add(new Rouge(name));
        // }
        // for (BaseHero character : rouges){
        //     System.out.println(character);
        // }
        // System.out.println("==========================");

        // ArrayList<BaseHero> snipers = new ArrayList<>();
        // String[] snipersNames = {"Михаил", "Иван", "Олег", "Денис", "Владислав"};
        // for (String name : snipersNames) {
        //     snipers.add(new Sniper(name));
        // }
        // for (BaseHero character : snipers){
        //     System.out.println(character);
        // }
        // System.out.println("==========================");

        // ArrayList<BaseHero> mages = new ArrayList<>();
        // String[] magesNames = {"Михаил", "Иван", "Олег", "Денис", "Владислав"};
        // for (String name : magesNames) {
        //     mages.add(new Mage(name));
        // }
        // for (BaseHero character : mages){
        //     System.out.println(character);
        // }
        // System.out.println("==========================");

        // ArrayList<BaseHero> spearmans = new ArrayList<>();
        // String[] spearmansNames = {"Михаил", "Иван", "Олег", "Денис", "Владислав"};
        // for (String name : spearmansNames) {
        //     spearmans.add(new Spearman(name));
        // }
        // for (BaseHero character : spearmans){
        //     System.out.println(character);
        // }
        // System.out.println("==========================");

        // ArrayList<BaseHero> crossbowMans = new ArrayList<>();
        // String[] crossbowMansNames = {"Михаил", "Иван", "Олег", "Денис", "Владислав"};
        // for (String name : crossbowMansNames) {
        //     crossbowMans.add(new CrossbowMan(name));
        // }
        // for (BaseHero character : crossbowMans){
        //     System.out.println(character);
        // }
        // System.out.println("==========================");

        // ArrayList<BaseHero> monks = new ArrayList<>();
        // String[] monksNames = {"Михаил", "Иван", "Олег", "Денис", "Владислав"};
        // for (String name : monksNames) {
        //     monks.add(new Monk(name));
        // }
        // for (BaseHero character : monks){
        //     System.out.println(character);
        // }
    }

    private static void generateHeroes(ArrayList<BaseHero> heroesList, int quantity, Random rand) {
        String[] namesList = {"Артём", "Александр", "Михаил", "Максим", "Иван", "Даниил", "Дмитрий", "Кирилл", "Никита", "Егор", "Матвей", "Андрей", "Илья", "Алексей", "Роман", "Сергей", "Владислав", "Ярослав", "Тимофей", "Арсений", "Денис", "Владимир", "Павел", "Глеб", "Константин", "Богдан", "Евгений", "Николай", "Степан", "Захар", "Тимур", "Марк", "Семён", "Фёдор", "Георгий", "Лев", "Антон", "Вадим", "Игорь", "Руслан", "Вячеслав", "Григорий", "Макар", "Артур", "Виктор", "Станислав", "Савелий", "Олег", "Давид", "Леонид", "Пётр", "Юрий", "Виталий", "Мирон", "Василий", "Всеволод", "Елисей", "Назар", "Родион", "Марат",
                "Платон", "Герман", "Игнат", "Святослав", "Анатолий", "Тихон", "Валерий", "Мирослав", "Ростислав", "Борис", "Филипп", "Демьян", "Гордей", "Валентин", "Демид", "Прохор", "Серафим", "Савва", "Яромир",
                "Аркадий", "Архип", "Тарас", "Трофим"};
        int namesSize = namesList.length;

        for (int i = 0; i < quantity; i++){
            int type = rand.nextInt(7);
            switch (type){
                case 0 -> heroesList.add(new CrossbowMan(namesList[rand.nextInt(namesSize)]));
                case 1 -> heroesList.add(new Farmer(namesList[rand.nextInt(namesSize)]));
                case 2 -> heroesList.add(new Mage(namesList[rand.nextInt(namesSize)]));
                case 3 -> heroesList.add(new Monk(namesList[rand.nextInt(namesSize)]));
                case 4 -> heroesList.add(new Rogue(namesList[rand.nextInt(namesSize)]));
                case 5 -> heroesList.add(new Sniper(namesList[rand.nextInt(namesSize)]));
                case 6 -> heroesList.add(new Spearman(namesList[rand.nextInt(namesSize)]));
            }

        }
    }
    private static void chooseHero(ArrayList<BaseHero> heroesList, String heroRole){
        System.out.printf("List of %s roles\n", heroRole);
        for (BaseHero hero : heroesList){
            if (hero.toString().contains(heroRole)){
                System.out.println(hero);
            }
        }
    }
}
