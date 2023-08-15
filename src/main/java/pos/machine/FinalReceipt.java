package pos.machine;

import java.util.List;

public class FinalReceipt {
    private final List<ItemsSubCost> itemsSubCost;
    private final int receiptItemsTotalCost;

    public FinalReceipt(List<ItemsSubCost> itemsSubCost, int receiptItemsTotalCost) {
        this.itemsSubCost = itemsSubCost;
        this.receiptItemsTotalCost = receiptItemsTotalCost;
    }

    public List<ItemsSubCost> getItemsSubCost() {
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
