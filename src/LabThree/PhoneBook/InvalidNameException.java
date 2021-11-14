package LabThree.PhoneBook;

public class InvalidNameException extends Exception{
    public String name;

    public InvalidNameException(String name) {
        super("InvalidNameException " + name);
        this.name = name;
    }
}
