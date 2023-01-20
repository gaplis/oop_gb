package Lections.Lection_1;

/**
 * Это точка 2D
 */
public class Point2D_001 {
    private int x, y;

    /**
     * Это конструктор...
     * @param valueX это координата X
     * @param valueY это координата Y
     */
    public Point2D_001(int valueX, int valueY) {
        x = valueX;
        y = valueY;
    }

    public Point2D_001(int value) {
        this(value, value);
    }

    public Point2D_001() {
        this(0);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void SetX(int value) {
        this.x = value;
    }

    public void SetY(int value) {
        this.y = value;
    }

    private String getInfo() {
        return String.format("x: %d; y: %d", x, y);
    }

    @Override
    public String toString() {
        return getInfo();
    }

    static double distance(Point2D_001 a, Point2D_001 b) {
        return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
    }
}
