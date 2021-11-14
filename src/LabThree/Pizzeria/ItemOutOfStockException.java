package LabThree.Pizzeria;

class
ItemOutOfStockException extends Exception {
    private Item item;

    public ItemOutOfStockException(Item item) {
        this.item = item;
    }
}
