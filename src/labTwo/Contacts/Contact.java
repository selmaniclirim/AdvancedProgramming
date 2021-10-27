package labTwo.Contacts;

public abstract class Contact {
    private String date;

    public Contact(String date) {
        this.date = date;
    }

    public boolean isNewerThan(Contact c) {
        return false;
    }

    public abstract String getType();
}
