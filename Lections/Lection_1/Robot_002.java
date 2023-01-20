package Lections.Lection_1;

import java.util.ArrayList;

public class Robot_002 {

    enum State {
        On, Off
    }

    private static int defaultIndex;
    private static ArrayList<String> names;

    static {
        defaultIndex = 1;
        names = new ArrayList<String>();
    }

    private int level;
    private String name;
    private State state;

    private Robot_002(String name, int level) {
        if ((name.isEmpty() || Character.isDigit(name.charAt(0))) || Robot_002.names.indexOf(name) != -1) {
            this.name = String.format("DefaultName_%d", defaultIndex++);
        } else {
            this.name = name;
        }
        
        Robot_002.names.add(this.name);
        this.level = level;
        this.state = State.Off;
    }

    public Robot_002(String name) {
        this(name, 1);
    }

    public Robot_002() {
        this("");
    }

    public void power() {
        if (this.state == State.Off) {
            this.powerOn();
            this.state = State.On;
        } else {
            this.powerOff();
            this.state = State.Off;
        }
        System.out.println();
    }

    private void powerOn() {
        this.startBIOS();
        this.startOS();
        this.sayHi();
    }

    private void powerOff() {
        this.sayBye();
        this.stopOS();
        this.stopBIOS();
    }

    public int getLevel() {
        return this.level;
    }

    public String getName() {
        return this.name;
    }

    private void startBIOS() {System.out.println("Start BIOS...");}

    private void startOS() {System.out.println("Start OS...");}

    private void sayHi() {System.out.println("Hello world...");}

    private void sayBye() {System.out.println("Bye...");}

    private void stopBIOS() {System.out.println("Stop BIOS...");}

    private void stopOS() {System.out.println("Stop OS...");}

    public void work() {
        if (this.state == State.On) {
            System.out.println("Working...");
        }
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("%s %d\n", this.name, this.level);
    }
}
