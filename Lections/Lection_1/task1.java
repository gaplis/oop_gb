package Lections.Lection_1;

public class task1 {
    public static void main(String[] args) {
        Point2D_001 a = new Point2D_001(0, 2);
        System.out.println(a.getX());
        System.out.println(a.getY());

        Point2D_001 b = new Point2D_001(8);
        System.out.println(b.getX());
        System.out.println(b.getY());
        b.SetY(2);
        System.out.println(b.getY());
        var dis = Point2D_001.distance(a, b);
        System.out.println(dis);
    }
}
