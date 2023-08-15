package pos.machine;

public class FinalReceipt {
    private final ItemsSubCost itemsSubCost;
    private final int receiptItemsTotalCost;

    public FinalReceipt(ItemsSubCost itemsSubCost, int receiptItemsTotalCost) {
        this.itemsSubCost = itemsSubCost;
        this.receiptItemsTotalCost = receiptItemsTotalCost;
    }

    public ItemsSubCost getItemsSubCost() {
        return itemsSubCost;
    }

    public int getReceiptItemsTotalCost() {
        return receiptItemsTotalCost;
    }

    @Override
    public String toString() {
        return "FinalReceipt{" +
                "itemsSubCost=" + itemsSubCost +
                ", receiptItemsTotalCost=" + receiptItemsTotalCost +
                '}';
    }
}
