////////////////////////////////////////////////////////////////////
// [VITTORIO] [SCHIAVON] [1187243]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.model;

public class MenuItem {
    private ItemType itemType;
    private String name;
    private double price;
    public MenuItem(ItemType itemType, String name, int price) {
        this.itemType = itemType;
        this.name = name;
        this.price = price;
    }
    public ItemType getItemType() {
        return itemType;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
}
