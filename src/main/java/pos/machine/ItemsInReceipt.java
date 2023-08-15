package pos.machine;

public class ItemsInReceipt {

    private final Item item;

    private final int quantity;

    public ItemsInReceipt(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "ItemsInReceipt{" +
                "item=" + item +
                ", quantity=" + quantity +
                '}';
    }
}
