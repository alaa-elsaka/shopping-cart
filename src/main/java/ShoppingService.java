import model.Cart;
import model.Item;
import model.Shopper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ShoppingService {

    //private  Shopper shopper = new Shopper();

    private Cart cart = new Cart();

    public double getSubtotal() {
        return subtotal;
    }

    private double subtotal;

    public boolean isCartEmpty() {
        return cart.getItems().isEmpty();
    }

    public void addItem(Item item) {

        cart.addItem(item);
        subtotal+= item.getPrice();
    }




    public int getQuantity(Item item) {
        return cart.getItems().get(item);
    }


    public Map<Item, Integer> getCartItems() {
        return cart.getItems();

    }

    public List<Item> getHighlightSales() {

        List<Item> items = new ArrayList<>(cart.getItems().keySet());
        List<Item> result = new ArrayList<>();
        for(Item item: items){
            if(item.isOnSale())
                result.add(item);
        }
        return result;
    }

    public void deleteItem(Item item) {

        if(cart.getItems().containsKey(item)
                && cart.getItems().get(item) > 1){
            cart.getItems().put(item,cart.getItems().get(item)-1);
        }
        else if(cart.getItems().containsKey(item)){
            cart.getItems().remove(item);
        }

    }
}
