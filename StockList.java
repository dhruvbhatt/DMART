package DS_TimBuchalka.SortedMaps_Sets;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockList {
    private final Map<String,StockItem> list;
    public StockList()
    {
        this.list=new LinkedHashMap<>();
    }
    public int addStock(StockItem Item) {
        if (Item != null) {
            if (list.get(Item.getItemName())==null) {
                list.put(Item.getItemName(), Item);//quantity added here itself if first input
            }
            else
            list.get(Item.getItemName()).adjustQuantity(Item.getItemQuantity());//current quantity added to EXISTING item in STOCKLIST
            return list.get(Item.getItemName()).getItemQuantity();
        }
        return 0;
    }

    public int SellStock(String Item, int quantity)
    {
        StockItem itemInStockList=list.get(Item);
        if(itemInStockList!=null && itemInStockList.getItemQuantity()>=quantity && quantity>0)
        {
            itemInStockList.adjustQuantity(-quantity);//-quanity so it reduces the quanitty duh
            return quantity;
        }
        return 0;
    }

    @Override
    public String toString() {
        double totalCost=0;
        for(StockItem item:list.values())
        {
            System.out.println(item.getItemQuantity()+" "+item.getItemName()+" are available");
            totalCost+=item.getItemPrice()*item.getItemQuantity();
        }
        return "Total Inventory Value is "+totalCost;
    }
    public StockItem get(String key) {
        return list.get(key);
    }

    public Map<String, StockItem> Items() {
        return Collections.unmodifiableMap(list);
    }

}
