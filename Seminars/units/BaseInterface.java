package Seminars.units;

import java.util.ArrayList;

public interface BaseInterface {

    void step(ArrayList<BaseHero> heroList);
    String getInfo();
    String getRole();
    String getType();

}
