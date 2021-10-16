package DS_TimBuchalka.SortedMaps_Sets;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Basket {
    private final String name;
    private Map<StockItem,Integer> basket;

    public Basket(String name) {
        this.name = name;
        basket=new TreeMap<>();
    }
    public void addToBasket(StockItem item, int quantity)
    {
        if(item!=null&&quantity>0)
        {
            int inBasket = basket.getOrDefault(item, 0);
            /**Can be simplified to one single statement since itemsInBasket if 0 won't affect the quantity,DUH!*/
            if(inBasket==0)
                basket.put(item,quantity);
            else
                basket.put(item,(inBasket+quantity));
        }
    }
    public boolean removeItemFromBasket(StockItem item, int quantity)
    {
        if(item==null||quantity<=0) {
            System.out.println("invalid request");
            return false;
        }
        if(this.getBasket().get(item)!=null)
        {
            if(this.getBasket().get(item)<=quantity)
            {
                if (this.getBasket().get(item)-quantity==0)
                {//remove the item from basket
                    this.basket.remove(item);
                }
                else
                {
                    this.basket.put(item,this.getBasket().get(item)-quantity);

                }
                item.removeFromBasket(quantity);
                return true;
            }
        }

        return false;
    }

    public String getName() {
        return name;
    }

    public Map<StockItem, Integer> getBasket() {
        return Collections.unmodifiableMap(basket);
    }

    @Override
    public String toString() {
        double totalCost=0;
        for(StockItem item: basket.keySet())
        {
            System.out.println(basket.get(item)+" "+item.getItemName()+" for Rs."+(item.getItemPrice()*basket.get(item)));
            totalCost+=item.getItemPrice()*basket.get(item);
        }
        return "Total cost to be payed is Rs."+totalCost;
    }
}
