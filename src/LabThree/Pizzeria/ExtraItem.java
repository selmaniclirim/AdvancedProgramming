package LabThree.Pizzeria;

class ExtraItem implements Item {
    private String type;
    private int price;
    private static final String[] validExtraItems = {"Coke", "Ketchup"};
    private static final int priceextra[] = {5, 3};

    private static boolean isValidType(String type) {
        return type.equals(validExtraItems[0]) || type.equals(validExtraItems[1]);
    }

    public ExtraItem(String type) throws InvalidExtraTypeException {
        if (!isValidType(type)) {
            throw new InvalidExtraTypeException();
        } else this.type = type;
    }

    public int getPrice() {
        int index = -1;
        for (int i = 0; i < priceextra.length; ++i) {
            if (type.equals(validExtraItems[i])) {
                index = i;
                break;
            }
        }
        return priceextra[index];
    }

    public String getType() {
        return type;
    }
}
