package labTwo.Contacts;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Contact {
    private String date;

    public Contact(String date) {
        this.date = date;
    }

    public boolean isNewerThan(Contact c) {
        Date date1 = null;
        Date date2 = null;
        try {
            date1=new SimpleDateFormat("yyyy-MM-dd").parse(date);
            date2=new SimpleDateFormat("yyyy-MM-dd").parse(c.date);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return date1.after(date2);
    }

    public abstract String getType();
}
