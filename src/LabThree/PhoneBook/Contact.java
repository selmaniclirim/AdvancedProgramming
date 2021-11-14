package LabThree.PhoneBook;
import java.io.Serializable;
import java.util.Arrays;

public class Contact implements Serializable, Comparable {
    private String name;
    private String[] phoneNumbers;

    public Contact(String name, String... phoneNumbers) throws InvalidNameException, InvalidNumberException, MaximumSizeExceededException {
        if (validateName(name))
            this.name = name;
        this.phoneNumbers = new String[phoneNumbers.length];
        for (int i = 0; i < phoneNumbers.length; i++) {
            if (i > 4) {
                throw new MaximumSizeExceededException();
            }
            if (validateNumber(phoneNumbers[i]))
                this.phoneNumbers[i] = phoneNumbers[i];
        }
    }

    public String getName() {
        return this.name;
    }

    public String[] getNumbers() {
        String[] temp = new String[phoneNumbers.length];
        System.arraycopy(phoneNumbers, 0, temp, 0, phoneNumbers.length);
        Arrays.sort(temp);
        return temp;
    }

    public void addNumber(String phoneNumber) throws InvalidNumberException {
        if (validateNumber(phoneNumber)) {
            phoneNumbers = Arrays.copyOf(phoneNumbers, phoneNumbers.length + 1);
            phoneNumbers[phoneNumbers.length - 1] = phoneNumber;
        }
    }

    public boolean validateName(String name) throws InvalidNameException {
        if (name.length() > 4 && name.length() <= 10 && name.matches("\\w+"))
            return true;
        throw new InvalidNameException(name);
    }

    private static boolean validateNumber(String phoneNumber) throws InvalidNumberException {
        String[] validOperators = {"070", "071", "072", "075", "076", "077", "078"};
        if (phoneNumber.length() != 9)
            throw new InvalidNumberException();
        for (int i = 0; i < phoneNumber.length(); ++i)
            if (phoneNumber.charAt(i) < 48 || phoneNumber.charAt(i) > 57)
                throw new InvalidNumberException();
        String operator = phoneNumber.substring(0, 3);
        if (!(operator.equals(validOperators[0]))
                && !(operator.equals(validOperators[1]))
                && !(operator.equals(validOperators[2]))
                && !(operator.equals(validOperators[3]))
                && !(operator.equals(validOperators[4]))
                && !(operator.equals(validOperators[5]))
                && !(operator.equals(validOperators[6])))
            throw new InvalidNumberException();
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append("\n");
        sb.append(phoneNumbers.length).append("\n");
        for(String i : getNumbers())
            sb.append(i).append("\n");
        return sb.toString();
    }

    @Override
    public int compareTo(Object o) {
        Contact contact = (Contact) o;
        return this.name.compareTo(contact.name);
    }
}
