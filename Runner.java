package DS_TimBuchalka.SortedMaps_Sets;

import GENERICS.Player;

import java.util.HashMap;

public class Runner {
    private static StockList Dmart=new StockList();
    public static void main(String[] args) {

        StockItem c5Star=new StockItem("5Star",20,21);
        StockItem pen=new StockItem("Pen",5,3);
        Dmart.addStock(c5Star);
        Dmart.addStock(pen);

        StockItem temp = new StockItem("bread", 0.86, 100);
        Dmart.addStock(temp);

        temp = new StockItem("cake", 1.10, 7);
        Dmart.addStock(temp);

        temp = new StockItem("car", 12.50, 2);
        Dmart.addStock(temp);

        temp = new StockItem("chair", 62.0, 10);
        Dmart.addStock(temp);

        temp = new StockItem("cup", 0.50, 200);
        Dmart.addStock(temp);

        temp = new StockItem("door", 72.95, 4);
        Dmart.addStock(temp);

        temp = new StockItem("juice", 2.50, 36);
        Dmart.addStock(temp);

        temp = new StockItem("phone", 96.99, 35);
        Dmart.addStock(temp);

        temp = new StockItem("towel", 2.40, 80);
        Dmart.addStock(temp);

        temp = new StockItem("vase", 8.76, 40);
        Dmart.addStock(temp);
        temp = new StockItem("vase", 7.76, 30);
        Dmart.addStock(temp);//overwrites old cost
        temp = new StockItem("test", 6.0, 40);
        Dmart.addStock(temp);
        System.out.println(Dmart);

        Basket DHRUV=new Basket("DHRUV");
        sellItem(DHRUV,"vase",31);
        sellItem(DHRUV,"vase",42);
        sellItem(DHRUV,"car",1);
        sellItem(DHRUV,"car",31);
        sellItem(DHRUV,"car",1);
        sellItem(DHRUV,"bread",5);
        sellItem(DHRUV,"5Star",5);

        System.out.println(DHRUV);
    }
    public static int sellItem(Basket basket,String item,int quantity)
    {//PUT IN BASKET, REMOVE FROM STOCKLIST.
        StockItem inStock=Dmart.get(item);
        if (inStock==null)
        {
            System.out.println("ITEM NOT AVAILABLE");
            return 0;
        }
        if(Dmart.SellStock(item,quantity)>0)
        {
            System.out.println("Item added to basket");
            basket.addToBasket(inStock,quantity);
            return quantity;
        }
        else
            System.out.println("Quantity available is "+inStock.getItemQuantity());
            return 0;
    }
    public static void checkout(Basket basket)
    {

        int totalCost=0;
        for(StockItem item:basket.getBasket().keySet())
        {
            Dmart.SellStock(item.getItemName(),basket.getBasket().get(item));
            totalCost+=item.getItemPrice()*basket.getBasket().get(item);//item.getquantity will return inventory quantity duh


        }
        System.out.println("TOTAL COST TO BE PAID IS: "+totalCost);
    }


}
