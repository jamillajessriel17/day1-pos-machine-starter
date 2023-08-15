package pos.machine;

public class ItemsSubCost {
    private final ItemsInReceipt itemsInReceipt;
    private final int subTotal;

    public ItemsInReceipt getItemsInReceipt() {
        return itemsInReceipt;
    }

    public int getSubTotal() {
        return subTotal;
    }

    public ItemsSubCost(ItemsInReceipt itemsInReceipt, int subTotal) {
        this.itemsInReceipt = itemsInReceipt;
        this.subTotal = subTotal;
    }

    @Override
    public String toString() {
        return "ItemsSubCost{" +
                "itemsInReceipt=" + itemsInReceipt +
                ", subTotal=" + subTotal +
                '}';
    }
}
