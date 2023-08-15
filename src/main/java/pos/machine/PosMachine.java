package pos.machine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PosMachine {
    public static String printReceipt(List<String> barcodes) {
        List<BarcodeListWithQuantity> barcodeListWithQuantityList = countSameBarcodes(barcodes);
        mapBarcodesToItems(barcodeListWithQuantityList);
        return null;
    }

    public static List<BarcodeListWithQuantity> countSameBarcodes(List<String> barcodes) {

        List<BarcodeListWithQuantity> barcodeListWithQuantityList = new ArrayList<>();
        List<String> uniqueBarcodes = new ArrayList<>();

        barcodes.stream()
                .filter(element -> !uniqueBarcodes.contains(element))
                .forEach(element -> uniqueBarcodes.add(element));

        uniqueBarcodes.stream()
                .forEach(element -> barcodeListWithQuantityList.add(new BarcodeListWithQuantity(element, Collections.frequency(barcodes, element))));

        return barcodeListWithQuantityList;
    }

    public static List<ItemsInReceipt> mapBarcodesToItems(List<BarcodeListWithQuantity> barcodeListWithQuantityList) {

        List<Item> itemList = ItemsLoader.loadAllItems();

        List<ItemsInReceipt> itemsInReceiptList = new ArrayList<>();

        for (Item item : itemList) {
            barcodeListWithQuantityList.stream()
                    .filter(itemInReceipt -> itemInReceipt.getBarcode().equals(item.getBarcode()))
                    .forEach(element -> itemsInReceiptList.add(new ItemsInReceipt(item,element.getQuantity())));
        }
        return itemsInReceiptList;
    }
}
