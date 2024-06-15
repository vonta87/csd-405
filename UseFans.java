import java.util.*;
import module1.FAN;

public class UseFans {
    // Method to display a collection of Fan instances without using the toString() method.
    public static void displayFans(Collection<Fan> fans) {
        for (Fan fan : fans) {
            fan.display();
        }
    }

    // Method to display a single instance of a Fan without using the toString() method.
    public static void displayFAN(FAN fan) {
        fan.display();
    }

    public static void main(String[] args) {
        // Creating a collection of Fan instances.
        Collection<Fan> fans = new ArrayList<>();
        fans.add(new Fan());
        fans.add(new Fan(true, Fan.MEDIUM, 12, "blue"));
        fans.add(new Fan(false, Fan.STOPPED, 8, "red"));

        // Displaying the collection of Fan instances.
        System.out.println("Displaying collection of fans:");
        displayFans(fans);

        // Displaying a single Fan instance.
        System.out.println("\nDisplaying a single fan:");
        Fan singleFan = new Fan(true, Fan.FAST, 10, "green");
        displayFan(singleFan);

        // Test the functionalities of the Fan instances.
        System.out.println("\nTesting functionalities:");
        Fan testFan = new Fan();
        testFan.display();
        testFan.toggleFan();
        testFan.display();
        testFan.increaseSpeed();
        testFan.display();
        testFan.setRadius(10);
        testFan.setColor("purple");
        testFan.display();
    }
}