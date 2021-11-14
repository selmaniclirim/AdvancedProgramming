package LabThree.Pizzeria;

class Order {
    private Item items[];
    private int counter[];
    private int itemnum;
    private boolean locked = false;

    public Order() {
        items = new Item[100];
        counter = new int[100];
        itemnum = 0;
    }

    public void addItem(Item item, int count) throws ItemOutOfStockException, OrderLockedException {
        boolean found = false;
        if (count > 10)
            throw new ItemOutOfStockException(item);
        else if (!locked) {
            for (int i = 0; i < itemnum; i++) {
                if (items[i].getType().equals(item.getType())) {
                    counter[i] = count;
                    found = true;
                    break;
                }
            }
            if (!found) {
                items[itemnum] = item;
                counter[itemnum] = count;
                itemnum++;
            }
        } else {
            throw new OrderLockedException();
        }
    }

    public int getPrice() {
        int totalprice = 0;
        for (int i = 0; i < itemnum; i++) {
            totalprice += items[i].getPrice() * counter[i];
        }
        return totalprice;

    }

    public void lock() throws EmptyOrder {
        if (itemnum == 0)
            throw new EmptyOrder();
        else
            locked = true;
    }

    public void removeItem(int idx) throws OrderLockedException {
        if (locked) {
            throw new OrderLockedException();
        } else {
            if (idx > itemnum)
                throw new OrderLockedException();
            else {
                for (int i = idx; i < itemnum; i++) {
                    items[i] = items[i + 1];
                    counter[i] = counter[i + 1];
                }
                items[itemnum] = null;
                counter[itemnum] = 0;
                itemnum--;
            }
        }
    }
    public void displayOrder() {

        for (int i = 0; i < itemnum; i++) {
            System.out.println(String.format("  %d.%-14s x %d   %2d$", i + 1, items[i].getType(), counter[i], (items[i].getPrice() * counter[i])));
        }
        System.out.println(String.format("Total:%-15s %5d$", " " , getPrice()));
    }
}
