// Javonta Young Assignment 5 June 22 2024
// This is program 1 where I am going to make an ArrayList and ask the caller to pick candy outside the list
// This will make an OutOfBounds exception so that will be displayed on the screen via the catch block

// imports needed for assignment
import java.util.ArrayList;
import java.util.Scanner;


public class ArrayListExample1 {
  public static void main(String[] args){
    ArrayList<String> list = new ArrayList<>();
    list.add("M&Ms");
    list.add("Snicker");
    list.add("Mike n Ike");
    list.add("Twix");
    list.add("Reese's");
    list.add("Hersey bar");
    list.add("Peanut M&M");
    list.add("KitKat");
    list.add("Whatchamacallit");
    list.add("100Grand");

     // Print all elements of the ArrayList using a for-each loop
     System.out.println("ArrayList elements:");
     for (String candy : list) {
         System.out.println(candy);
     }

     // Ask the user which element they would like to see again
     Scanner scanner = new Scanner(System.in);
     System.out.print("\nEnter the index of the element you would like to see again (0-9): ");
     String input = scanner.nextLine();

     // Try to parse the input and access the element, handling any exceptions
     try {
         // Auto-unboxing from Integer to int
         int index = Integer.parseInt(input);

         // Attempt to access the element at the specified index
         System.out.println("Element at index " + index + " is: " + list.get(index));
     } catch (NumberFormatException e) {
         System.out.println("Invalid input. Please enter a valid integer index.");
     } catch (IndexOutOfBoundsException e) {
         System.out.println("Out of Bounds. Please enter an index between 0 and 9.");
     }

     // Close the scanner
     scanner.close();
 }
}