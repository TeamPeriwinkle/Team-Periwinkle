import java.util.ArrayList;

/**
 * Item object class.
 * @author Soe Lin
 */

public class Item {

    private String name;

    private Double price;

    private int unit;

    public Item(String theName, Double thePrice, int theUnit) {
        name = theName;
        price = thePrice;
        unit = theUnit;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public int getUnit() {
        return unit;
    }

    public void setName(String theName) {
        name = theName;
    }

    public void setPrice(Double thePrice) {
        price = thePrice;
    }

    public void setUnit(int theUnit) {
        unit = theUnit;
    }

    @Override
    public String toString() {
        return String.format("%s, price per unit: $%.2f, total unit: %d, total price: $%.2f", name, price, unit, price * unit);
    }

    public static void main(String[] theArgs) {
        ArrayList<Item> myItemList = new ArrayList<>();
        myItemList.add(new Item("Rice", 38.50, 3));
        myItemList.add(new Item("IPhone12", 969.55, 2));
        myItemList.add(new Item("Sticker", 3.50, 3));
        for (int i = 0; i < myItemList.size(); i++) {
            System.out.println(myItemList.get(i));
        }
        
    }

}
