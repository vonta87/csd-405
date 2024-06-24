// Javonta Young Assignment 6 June 23 2024
//This is where I am going to pull the files that need to be used and display them accordingly

public class UseDivision {
    public static void main(String[] args) {
        InternationalDivision internationalDivision1 = new InternationalDivision("Europe Division", 101, "Germany", "German");
        InternationalDivision internationalDivision2 = new InternationalDivision("Asia Division", 102, "Japan", "Japanese");

        DomesticDivision domesticDivision1 = new DomesticDivision("West Coast Division", 201, "California");
        DomesticDivision domesticDivision2 = new DomesticDivision("East Coast Division", 202, "New York");

        internationalDivision1.display();
        System.out.println();
        internationalDivision2.display();
        System.out.println();
        domesticDivision1.display();
        System.out.println();
        domesticDivision2.display();
    }
}
