package Seminars.units;

import java.util.ArrayList;

public interface BaseInterface {

    void step(ArrayList<BaseHero> friendList, ArrayList<BaseHero> enemyList);
    String getInfo();
    String getRole();
    String getType();
    boolean getStatus();
    int getSpeed();
    ArrayList<BaseHero> getTeam();
}
