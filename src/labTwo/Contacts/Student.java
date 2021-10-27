package labTwo.Contacts;

import java.util.Arrays;
import java.util.Objects;

public class Student {

    private String firstName;
    private String lastName;
    private String city;
    private int age;
    private long index;
    private Contact contact[] = new Contact[5];

    public Student(String firstName, String lastName, String city, int age, long index) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.age = age;
        this.index = index;
    }

    public void addEmailContact(String date, String email) {
        if(contact[contact.length-1] != null) {
            contact = Arrays.copyOf(contact, contact.length * 2);
        }
        for(int i = 0; i < contact.length; i++){
            if (contact[i] == null)
                contact[i] = new EmailContact(date, email);
        }
    }

    public void addPhoneContact(String date, String phone) {
        if(contact[contact.length-1] != null) {
            contact = Arrays.copyOf(contact, contact.length * 2);
        }
        for(int i = 0; i < contact.length; i++){
            if (contact[i] == null)
                contact[i] = new PhoneContact(date, phone);
        }
    }
    public Contact[] getEmailContacts() {
        Contact[] emailContacts = new Contact[contact.length];
        int x = 0;
        for (Contact value : contact) {
            if (Objects.equals(value.getType(), "Email"))
                emailContacts[x] = value;
        }
        return emailContacts;
    }

    public Contact[] getPhoneContacts() {
        Contact[] phoneContacts = new Contact[contact.length];
        int x = 0;
        for (Contact value : contact) {
            if (Objects.equals(value.getType(), "Phone"))
                phoneContacts[x] = value;
        }
        return phoneContacts;
    }

    public int getTotalContacts() {
        return contact.length;
    }

    public String getCity() {
        return city;
    }

    public int getAge() {
        return age;
    }

    public String getFullName() {
        return String.format("%s %s", firstName, lastName);
    }

    public long getIndex() {
        return index;
    }

    public Contact getLatestContact() {
        return contact[contact.length - 1];
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{\"ime\":\"").append(getFirstName()).append("\", ");
        stringBuilder.append("\"prezime\":\"").append(getLastName()).append("\", ");
        stringBuilder.append("\"vozrast\":\"").append(getAge()).append("\", ");
        stringBuilder.append("\"grad\":\"").append(getCity()).append("\", ");
        stringBuilder.append("\"indeks\":\"").append(getIndex()).append("\", ");

        //Start appending phone contacts:
        stringBuilder.append("\"telefonskiKontakti\":[");
        for(int i = 0; i < getPhoneContacts().length; i++) {
            stringBuilder.append("\"").append(getPhoneContacts()[i]).append("\", ");
        }
        stringBuilder.append("], ");
        //End append phoneContact Array.

        //Start appending email contacts
        stringBuilder.append("\"emailKontakti\":[");
        for(int i = 0; i < getEmailContacts().length; i++) {
            stringBuilder.append("\"").append(getEmailContacts()[i]).append("\", ");
        }
        stringBuilder.append("]}");
        //End Appending email contacts and finish toString method();

        return stringBuilder.toString();
    }
}
