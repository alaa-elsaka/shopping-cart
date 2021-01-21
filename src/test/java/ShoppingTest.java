import model.Cart;
import model.Item;
import model.Shopper;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShoppingTest {

    ShoppingService shoppingService = new ShoppingService();
    Item item1 = new Item("AA", 2);
    Item item2 = new Item("BB",3);
    Item item3 = new Item("CC",6);
    Item item4 = new Item("DD",4);
    @Test
    public  void isCartempty_check_cart_isempty()
    {
        assertTrue(shoppingService.isCartEmpty());
    }

    @Test
    public void addItemAndUpdateSubtotalEmptyCart(){

        Item item = new Item("AA",2);
        shoppingService.addItem(item);
        double result = shoppingService.getSubtotal();
        assertEquals(2,result);
    }
    @Test
    public void addItemAndUpdateSubtotalCartWithItems(){


        shoppingService.addItem(item1);
        shoppingService.addItem(item2);
        shoppingService.addItem(item3);
        shoppingService.addItem(item4);
        double result = shoppingService.getSubtotal();

        assertEquals(15,result);
    }

    @Test
    public void addItemAndUpdateQuantity(){
        shoppingService.addItem(item1);
        shoppingService.addItem(item1);

        int result = shoppingService.getQuantity(item1);

        assertEquals(2, result);

    }

    @Test
    public void getCartItems(){
        Map<Item,Integer> expectedItems = new HashMap<>();
        expectedItems.put(item1,1);
        expectedItems.put(item2,1);
        expectedItems.put(item3,1);
        expectedItems.put(item4,1);


        shoppingService.addItem(item1);
        shoppingService.addItem(item2);
        shoppingService.addItem(item3);
        shoppingService.addItem(item4);

        Map<Item,Integer> result = shoppingService.getCartItems();

        assertEquals(expectedItems,result);
    }

    @Test
    public void checkHighlightedSales(){
        item1.setOnSale(true);
        item2.setOnSale(true);
        shoppingService.addItem(item1);
        shoppingService.addItem(item2);
        shoppingService.addItem(item3);
        shoppingService.addItem(item4);

        List<Item> expectedItems = new ArrayList<>();
        expectedItems.add(item1);
        expectedItems.add(item2);

        List<Item> results = shoppingService.getHighlightSales();

        assertEquals(expectedItems, results);

    }

    @Test
    public void checkRemoveItem(){
        shoppingService.addItem(item1);
        shoppingService.addItem(item2);
        shoppingService.addItem(item3);
        shoppingService.addItem(item4);

        Map<Item,Integer> expectedItems = new HashMap<>();
        expectedItems.put(item1,1);
        expectedItems.put(item2,1);
        expectedItems.put(item3,1);

        shoppingService.deleteItem(item4);

        Map<Item,Integer> result = shoppingService.getCartItems();

        assertEquals(expectedItems,result);

    }

    @Test
    public void checkRemoveItemCheckQuantity(){
        shoppingService.addItem(item1);
        shoppingService.addItem(item2);
        shoppingService.addItem(item3);
        shoppingService.addItem(item4);
        shoppingService.addItem(item4);

        Map<Item,Integer> expectedItems = new HashMap<>();
        expectedItems.put(item1,1);
        expectedItems.put(item2,1);
        expectedItems.put(item3,1);
        expectedItems.put(item4,1);

        shoppingService.deleteItem(item4);

        Map<Item,Integer> result = shoppingService.getCartItems();

        assertEquals(expectedItems,result);

    }

}
