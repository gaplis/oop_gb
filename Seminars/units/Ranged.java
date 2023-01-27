package Seminars.units;

import java.util.ArrayList;

public class Ranged extends BaseHero {

    int shoots;

    public Ranged(String name, String role, int attack, int defence, int[] damage, int health, int speed, int shoots) {
        super(name, role, attack, defence, damage, health, speed);
        this.shoots = shoots;
    }

    @Override
    public String toString() {
        return super.toString() + ", Shoots: " + shoots;
    }

    @Override
    public void step(ArrayList<BaseHero> heroList) {
        if (shoots != 0) {
            System.out.println("Боец -" + this.getRole() + "- по имени " + this.getName() + " делает один выстрел.");
            shoots--;
        } else {
            System.out.println("У бойца -" + this.getRole() + "- по имени " + this.getName() + " нет стрел.");
        }

        for (int i = 0; i < heroList.size(); i++) {
            if(heroList.get(i).getRole().equals("Farmer")) {
                if(((Farmer)heroList.get(i)).supply == true){
                    shoots++;
                    ((Farmer)heroList.get(i)).supply = false;
                    System.out.println("Фермер по имени " + heroList.get(i).getName() +  " возвращает бойцу -" + this.getType() 
                    + "- по имени " + this.getName() + " одну стрелу и становится неактивен.");
                    break; // чтобы только один фермер принёс стрелу обратно одному лучнику, а то без прерываний все фермеры будут нести,
                    // а следующим лучникам фермера не достанется)
                } else {
                    System.out.println("Фермер по имени " + heroList.get(i).getName() 
                    + " был не активен, потому не принёс стрелу обратно.");
                }
            }
        }

        System.out.println("Оставшееся количество выстрелов: " + shoots);
    }

    @Override
    public String getType() {
        return "Ranged";
    }
}