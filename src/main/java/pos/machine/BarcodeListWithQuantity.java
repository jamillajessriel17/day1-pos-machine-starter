package pos.machine;

public class BarcodeListWithQuantity {
    private final String barcode;
    private final int quantity;

    public BarcodeListWithQuantity(String barcode, int quantity) {
        this.barcode = barcode;
        this.quantity = quantity;
    }

    public String getBarcode() {
        return barcode;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "BarcodeListWithQuantity{" +
                "barcode='" + barcode + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
