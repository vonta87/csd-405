public class FAN {
    //Constants
    public static final int STOPPED = 0;
    public static final int SLOW = 1;
    public static final int MEDIUM = 2;
    public static final int FAST = 3;

    // Private fields
    private int speed;
    private boolean on;
    private double radius;
    private String color;

    //Constructors
    public FAN() {
        this.speed = STOPPED;
        this.on = false;
        this.radius = 6;
        this.color = "white";

    }

    public FAN (int speed,boolean on, double radius, String color) {
        this.speed = speed;
        this.on = on;
        this.radius = radius;
        this.color = color;

    }

    //Getters and Setters
    public int getSpeed() {
        return this.speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public boolean isOn() {
        return this.on;
    }
    public void setOn(boolean on) {
        this.on = on;
    }
    public double getRadius() {
        return this.radius;
    }
    public double setRadius(double radius) {
        return this.radius = radius;
    }
    public String getColor(){
        return this.color;
    }
    public String setColor(String color) {
        return this.color = color;
    }

    //toString method
    public String toString() {
        String str ="speed: " + this.speed + "\n";
        str += "color: " + this.color + "\n";
        str += "radius: " + this.radius + "\n";
        if (this.on) {
            str += "fan is on";
        }
        else {
            str += "Fan is off";
        }
        return str;
    }

    public static void main(String[] args) {
        FAN firstFanObject = new FAN();
        FAN secondFanObject = new FAN(FAN.FAST,true,10,"yellow");
        
        System.out.println("Fan 1:\n" + firstFanObject);
        System.out.println("\nFan 2:\n" + secondFanObject);
    }
}
