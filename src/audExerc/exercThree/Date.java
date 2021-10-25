package audExerc.exercThree;

public class Date {
    private static final int FIRST_YEAR = 1800;
    private static final int LAST_YEAR = 2500;
    private static final int DAYS_IN_YEAR = 365;
    private static final int[] daysOfMonth = {
            31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
    };
    private static final int[] daysTillFirstOfMonth;
    private static final int[] daysTillJan1;

    static {
        daysTillFirstOfMonth = new int[12];
        for (int i = 1; i < 12; i++) {
            daysTillFirstOfMonth[i] += daysTillFirstOfMonth[i - 1] + daysOfMonth[i - 1];
        }
        int totalYears = LAST_YEAR - FIRST_YEAR + 1;
        daysTillJan1 = new int[totalYears];
        int currentYear = FIRST_YEAR;
        for (int i = 1; i < totalYears; i++) {
            if (isLeapYear(currentYear)) {
                daysTillJan1[i] = daysTillJan1[i - 1] + DAYS_IN_YEAR + 1;
            } else {
                daysTillJan1[i] = daysTillJan1[i - 1] + DAYS_IN_YEAR;
            }
            currentYear++;
        }
    }

    private static boolean isLeapYear(int year) {
        return (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0));
    }

    private final int days;

    public Date(int days) {
        this.days = days;
    }

    public Date(int date, int month, int year) {
        int days = 0;
        if (year < FIRST_YEAR || year > LAST_YEAR) {
            throw new RuntimeException();
        }
        days += daysTillJan1[year - FIRST_YEAR];
        days += daysTillFirstOfMonth[month - 1];
        if (month > 2 && isLeapYear(year)) {
            days++;
        }
        days += date;
        this.days = days;
    }

    public int subtract(Date date) {
        return this.days - date.days;
    }

    public Date increment(int days) {
        return new Date(this.days + days);
    }

    @Override
    public boolean equals(Object other) {
        Date date = (Date) other;
        return this.days == date.days;
    }

    public int compareTo(Date date) {
        return this.days - date.days;
    }

    @Override
    public String toString() {
        int d = days;
        int i;
        for (i = 0; i < daysTillJan1.length; i++) {
            if (daysTillJan1[i] >= days) {
                break;
            }
        }
        d -= daysTillJan1[i - 1];
        int year = FIRST_YEAR + i - 1;
        if (isLeapYear(year)) {
            d--;
        }
        for (i = 0; i < daysTillFirstOfMonth.length; i++) {
            if (daysTillFirstOfMonth[i] >= d) {
                break;
            }
        }
        int month = i;
        d -= daysTillFirstOfMonth[i - 1];
        return String.format("%02d.%02d.%4d", d, month, year);
    }

    public static void main(String[] args) {
        Date sample = new Date(1, 10, 2012);
        System.out.println(sample.subtract(new Date(1, 1, 2000)));
        System.out.println(sample);
        sample = new Date(1, 1, 1800);
        System.out.println(sample);
        sample = new Date(31, 12, 2500);
        System.out.println(daysTillJan1[daysTillJan1.length - 1]);
        System.out.println(sample.days);
        System.out.println(sample);
        sample = new Date(30, 11, 2012);
        System.out.println(sample);
        sample = sample.increment(100);
        System.out.println(sample);
    }
}