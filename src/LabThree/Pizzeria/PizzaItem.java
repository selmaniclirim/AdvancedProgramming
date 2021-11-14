package LabThree.Pizzeria;

class PizzaItem implements Item {
    private String type;
    private static final int pricepizza[] = {10, 12, 8};
    private static final String validPizza[] = {"Standard", "Pepperoni", "Vegetarian"};

    private static boolean isValidType(String type) {
        return type.equals(validPizza[0]) || type.equals(validPizza[1]) || type.equals(validPizza[2]);
    }

    public PizzaItem(String type) throws InvalidPizzaTypeException {
        if (!isValidType(type)) {
            throw new InvalidPizzaTypeException();
        } else this.type = type;
    }

    public int getPrice() {
        int index = -1;
        for (int i = 0; i < pricepizza.length; ++i) {
            if (type.equals(validPizza[i])) {
                index = i;
                break;
            }
        }
        return pricepizza[index];
    }

    public String getType() {
        return type;
    }
}
