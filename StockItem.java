package DS_TimBuchalka.SortedMaps_Sets;

public class StockItem implements Comparable{
    private final String ItemName;
    private double ItemPrice;
    private int ItemQuantity;
    private int reservedQuantity;

    public StockItem(String itemName, double itemPrice, int itemQuantity) {
        ItemName = itemName;
        ItemPrice = itemPrice;
        ItemQuantity = itemQuantity;
        reservedQuantity=0;
    }
    public void addToBasket(int itemQuantity)
    {
        if(itemQuantity<=this.getItemQuantity())
        {
            reservedQuantity+=itemQuantity;
            System.out.println("items reserved");
        }
        else
            System.out.println(itemQuantity+" requested while only "+(this.getItemQuantity()+" is left"));
    }
    public void removeFromBasket(int itemQuantity)
    {
        if(itemQuantity<=reservedQuantity)
        {
            reservedQuantity-=itemQuantity;
            this.adjustQuantity(itemQuantity);
            System.out.println(itemQuantity+" items remmoved");
        }
        else
            System.out.println(itemQuantity+" requested to be removed while only "+(reservedQuantity+" items are in basket"));
    }

    public int getReservedQuantity() {
        return reservedQuantity;
    }

    public void setReservedQuantity(int reservedQuantity) {
        this.reservedQuantity = reservedQuantity;
    }

    public String getItemName() {
        return ItemName;
    }

    public double getItemPrice() {
        return ItemPrice;
    }

    public int getItemQuantity() {
        return this.ItemQuantity-reservedQuantity;
    }

    public void setItemPrice(double itemPrice) {
        if(itemPrice>0)
        this.ItemPrice = itemPrice;
    }

    //ADJUST QUANTITY INSTEAD OF SET, SO INCREASE AND DECREASE POSSIBLE
    public void adjustQuantity(int value)
    {
        if(this.ItemQuantity+value>=0)
        {
            this.ItemQuantity+=value;
        }
    }

    @Override
    public int hashCode() {
        return this.ItemName.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj)
            return true;
        if(obj!=null&&obj.getClass()==this.getClass())
            return this.ItemName.equals(((StockItem)obj).ItemName);
        else
            return false;
    }

    @Override
    public int compareTo(Object o) {
        return this.ItemName.compareToIgnoreCase(((StockItem)o).getItemName());
    }
}
