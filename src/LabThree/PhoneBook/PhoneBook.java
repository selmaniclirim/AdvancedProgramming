package LabThree.PhoneBook;

import java.io.*;
import java.util.Arrays;
import java.util.Objects;

public class PhoneBook {
    private Contact[] contacts;
    private int contactCounter;

    public PhoneBook() {
        contacts = new Contact[0];
        contactCounter = 0;
    }

    void addContact(Contact contact) throws MaximumSizeExceededException, InvalidNameException {
        if (contacts.length > 250)
            throw new MaximumSizeExceededException();
        for(int i = 0; i < contacts.length; i++) {
            if(contacts[i].getName().equals(contact.getName()))
                throw new InvalidNameException(contact.getName());
        }
        contacts = Arrays.copyOf(contacts, contacts.length + 1);
        contacts[contactCounter] = contact;
        contactCounter++;
    }

    public Contact getContactForName(String name) {
        for (Contact contact : contacts)
            if (Objects.equals(contact.getName(), name))
                return contact;
        return null;
    }

    public int numberOfContacts() {
        return contacts.length;
    }

    public Contact[] getContacts() {
        Contact[] sortedContacts;
        sortedContacts = Arrays.copyOf(contacts, contacts.length);
        Arrays.sort(sortedContacts);
        Arrays.sort(contacts);
        return sortedContacts;

    }

    public boolean removeContact(String name) throws MaximumSizeExceededException, InvalidNameException {
        if(getContactForName(name) == null)
            return false;
        PhoneBook temp = new PhoneBook();
        for(int i = 0; i < contactCounter; i++) {
            if(!(Objects.equals(contacts[i].getName(), name))) {
                temp.addContact(contacts[i]);
            }
        }
        contacts = temp.contacts;
        return true;
    }

    public Contact[] getContactsForNumber(String number_prefix) {
        int counter = 0;
        for (int i = 0; i < getContacts().length; ++i) {
            for (int j = 0; j < getContacts()[i].getNumbers().length; ++j) {
                String prefix = getContacts()[i].getNumbers()[j].substring(0, 3);
                if (prefix.equals(number_prefix)) {
                    ++counter;
                    break;
                }
            }
        }
        Contact[] contacts = new Contact[counter];
        for (int i = 0, k = 0; i < getContacts().length; ++i) {
            for (int j = 0; j < getContacts()[i].getNumbers().length; ++j) {
                String prefix = getContacts()[i].getNumbers()[j].substring(0, 3);
                if (prefix.equals(number_prefix)) {
                    contacts[k++] = this.contacts[i];
                    break;
                }
            }
        }
        return contacts;
    }

    public static boolean saveAsTextFile(PhoneBook phonebook, String path) {
        File file = new File(path);
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
            out.writeObject(phonebook);
            out.close();
        } catch (FileNotFoundException e) {
            try {
                if (file.createNewFile()) {
                    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
                    out.writeObject(phonebook);
                    out.close();
                }
            } catch (IOException e1) {
                return false;
            }
        } catch (IOException e) {
            return false;
        }
        return true;
    }
    public static PhoneBook loadFromTextFile(String path) throws IOException, InvalidFormatException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));
        PhoneBook pb = null;
        try {
            pb = (PhoneBook) in.readObject();
            in.close();
        } catch (ClassNotFoundException e) {
            throw new InvalidFormatException();
        }
        return pb;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Contact contact : contacts)
            sb.append(contact.toString()).append("\n");
        return sb.toString();
    }

}
