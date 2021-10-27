package labTwo.Contacts;

public class PhoneContact extends Contact{
    private String phone;
    private Operator operator;

    public PhoneContact(String date, String phone) {
        super(date);
        this.phone = phone;
        for(int i = 0; i < 9; i++) {
            if(phone.startsWith("07" + i)  && i < 3)
                operator = Operator.TMOBILE;
            else if(phone.startsWith("07" + i) && (i > 4 && i < 7))
                operator = Operator.ONE;
            else if(phone.startsWith("07" + i) && i >= 7) {
                operator = Operator.VIP;
            }
        }
    }

    public String getPhone() {
        return phone;
    }

    public String getOperator() {
        return operator.toString();
    }

    @Override
    public String getType() {
        return "Phone";
    }

    @Override
    public String toString() {
        return phone;
    }
}
