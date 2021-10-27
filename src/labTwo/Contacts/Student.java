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
            if (contact[i] == null) {
                contact[i] = new EmailContact(date, email);
                break;
            }
        }
    }

    public void addPhoneContact(String date, String phone) {
        if(contact[contact.length-1] != null) {
            contact = Arrays.copyOf(contact, contact.length * 2);
        }

        for(int i = 0; i < contact.length; i++){
            if (contact[i] == null) {
                contact[i] = new PhoneContact(date, phone);
                break;
            }
        }
    }
    public Contact[] getEmailContacts() {
        Contact[] emailContacts = new Contact[0];
        int x = 0;
        for (Contact value : contact) {
            if (value != null && Objects.equals(value.getType(), "Email")) {
                emailContacts = Arrays.copyOf(emailContacts, emailContacts.length + 1);
                emailContacts[x] = value;
                x++;
            }
        }
        return emailContacts;
    }

    public Contact[] getPhoneContacts() {
        Contact[] phoneContacts = new Contact[0];
        int x = 0;
        for (Contact value : contact) {
            if (value != null && Objects.equals(value.getType(), "Phone")) {
                phoneContacts = Arrays.copyOf(phoneContacts, phoneContacts.length + 1);
                phoneContacts[x] = value;
                x++;
            }

        }
        return phoneContacts;
    }

    public int getTotalContacts() {
        int totalContacts = 0;
        for(Contact contact : contact) {
            if(contact != null)
                totalContacts++;
        }
        return totalContacts;
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
        Contact newestContact;
        newestContact = contact[0];
        for(Contact contact : contact) {
            if(contact != null && contact.isNewerThan(newestContact))
                newestContact = contact;
        }
        return newestContact;
    }

//    public int getTrueLength(Contact[] contact) {
//        int count = -1;
//        for(int i = 0; i < contact.length; i++) {
//            if(contact[i] != null)
//                count++;
//        }
//        return count;
//    }

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
        stringBuilder.append("\"vozrast\":").append(getAge()).append(", ");
        stringBuilder.append("\"grad\":\"").append(getCity()).append("\", ");
        stringBuilder.append("\"indeks\":").append(getIndex()).append(", ");

        //Start appending phone contacts:
        stringBuilder.append("\"telefonskiKontakti\":[");
        for(int i = 0; i < getPhoneContacts().length; i++) {
            stringBuilder.append("\"").append(getPhoneContacts()[i]).append("\"");
            if(i != getPhoneContacts().length - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("], ");
        //End append phoneContact Array.

        //Start appending email contacts
        stringBuilder.append("\"emailKontakti\":[");
        for(int i = 0; i < getEmailContacts().length; i++) {
            stringBuilder.append("\"").append(getEmailContacts()[i]).append("\"");
            if(i != getEmailContacts().length - 1) {
                stringBuilder.append(", ");
            }

        }
        stringBuilder.append("]}");
        //End Appending email contacts and finish toString method();

        return stringBuilder.toString();
    }
}
