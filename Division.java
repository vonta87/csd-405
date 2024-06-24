// Javonta Young Assignment 6 June 22 2024
// this is the superclass that we will be using so the subclass International and Domestic can oull from

public abstract class Division {
    protected String divisionName;
    protected int accountNumber;

    public Division(String divisionName, int accountNumber) {
        this.divisionName = divisionName;
        this.accountNumber = accountNumber;
    }

    public abstract void display();
}




