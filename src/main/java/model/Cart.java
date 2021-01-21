package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {
    Map<Item,Integer> items = new HashMap<>();

    public Map<Item,Integer> getItems(){

        return items;
    }

    public void addItem(Item item){
        if(!items.containsKey(item)){
            items.put(item,1);
        }
        else{
            items.put(item,items.get(item)+1);
        }

    }


}
