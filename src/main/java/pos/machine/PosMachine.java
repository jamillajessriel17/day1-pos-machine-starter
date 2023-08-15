package pos.machine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PosMachine {
    public static String printReceipt(List<String> barcodes) {
        List<BarcodeListWithQuantity> barcodeListWithQuantityList = countSameBarcodes(barcodes);
        List<ItemsInReceipt> itemsInReceiptList= mapBarcodesToItems(barcodeListWithQuantityList);
        FinalReceipt finalReceipt = calculateCost(itemsInReceiptList);

        return generateReceipt(finalReceipt);
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
    public static FinalReceipt calculateCost(List<ItemsInReceipt> itemsInReceiptList){
        List <ItemsSubCost> itemsSubCostList = calculateSubCost(itemsInReceiptList);
        int  totalPrice = calculateTotalCost(itemsSubCostList);
        return new FinalReceipt(itemsSubCostList,totalPrice);
    }
    public static List<ItemsSubCost> calculateSubCost(List<ItemsInReceipt> itemsInReceiptList){
        List<ItemsSubCost> itemsSubCostList = new ArrayList<>();
        itemsInReceiptList.stream()
                          .forEach(element -> itemsSubCostList.add(new ItemsSubCost(element, element.getQuantity()* element.getItem().getPrice())));

        return itemsSubCostList;
    }
    public static int calculateTotalCost( List <ItemsSubCost> itemsSubCostList){

        return itemsSubCostList.stream()
                .map(element -> element.getSubTotal())
                .reduce((a,b)-> Integer.sum(a,b)).orElse(0);
    }
    public static String generateReceipt(FinalReceipt finalReceipt){
        StringBuilder string = new StringBuilder();
        string.append("***<store earning no money>Receipt***");
        finalReceipt.getItemsSubCost().stream()
                .forEach(element -> string.append("\n")
                                      .append(String.format("Name: %s, Quantity: %s, Unit price: %s (yuan), Subtotal: %s (yuan)", element.getItemsInReceipt().getItem().getName(),
                                              element.getItemsInReceipt().getQuantity(),
                                              element.getItemsInReceipt().getItem().getPrice(),
                                              element.getSubTotal())));
        string.append("\n").append("----------------------")
                .append("\n")
                .append(String.format("Total: %s (yuan)", finalReceipt.getReceiptItemsTotalCost()))
                .append("\n")
                .append("**********************");
        return String.format(string.toString());
    }
}
