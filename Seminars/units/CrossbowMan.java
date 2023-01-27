package Seminars.units;

public class CrossbowMan extends Ranged{
    int shoots;
    
    public CrossbowMan(String name) {
        super(name, "Crossbow Man", 6, 3, new int[] {2, 3}, 10, 4, 16);
    }
}
