package Seminars;

public class Vector2 {
    public double x, y;

    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public boolean isEquals(Vector2 opposit) {
        if (opposit.y == y && opposit.x == x) return true;
        return false;
    }

    protected Vector2 getPosition(){
        return new Vector2(x, y);
    }
}
