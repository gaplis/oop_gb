package Lections.Lection_1;

public class task2 {
    public static void main(String[] args) {
        Robot_002 robot = new Robot_002("name_1");
        System.out.println("------------------");
        System.out.println(robot);
        
        robot.power();
        robot.work();
        robot.power();
        robot.work();

        robot.power();
    }
}
