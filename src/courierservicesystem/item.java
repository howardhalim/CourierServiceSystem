package courierservicesystem;
public class item {
    String itemId, cost, itemName;

    public item() {
    }

    public item(String itemId, String cost, String itemName) {
        this.itemId = itemId;
        this.cost = cost;
        this.itemName = itemName;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
