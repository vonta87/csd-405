// Assignment module 4
// In this code I will be displaying how to get an ArrayList of numbers and display the list and the max of the numbers

// Imported classes needed to perform this coding assignment

package module04;

import java.util.ArrayList;
import java.util.Scanner;

public class JavontaArrayListTest {
    public static Integer max(ArrayList<Integer> list) {

        // Check if list is empty
        if (list.size() == 0) {
            return 0;
        }

        // Find the max in the list
        Integer max = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        Scanner input = new Scanner(System.in);
        System.out.print("Enter integers (input ends with 0): ");
        int value;

        do {
            value = input.nextInt(); // This reads the inputted value from the user
            if (!list.contains(value) && value != 0) {
                list.add(value);
            }
        } while (value != 0);

        // After the numbers are entered and added, let's check to see if the list is empty
        System.out.println("List size? " + list.size());
        System.out.println("Is the list empty? " + list.isEmpty()); // Prints false if values were entered

        // Display the numbers
        System.out.print("The integers are: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

        // Display the max value in the list
        System.out.println("\nThe maximum value is " + max(list));
    }
}
