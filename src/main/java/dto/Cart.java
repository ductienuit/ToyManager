package dto;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    private HashMap<Long, OrderDetail> cartOrderDetails;

    public Cart() {
        cartOrderDetails = new HashMap<>();
    }

    public Cart(HashMap<Long, OrderDetail> cartOrderDetails) {
        this.cartOrderDetails = cartOrderDetails;
    }

    public HashMap<Long, OrderDetail> getCartOrderDetails() {
        return cartOrderDetails;
    }

    public void setCartOrderDetails(HashMap<Long, OrderDetail> cartOrderDetails) {
        this.cartOrderDetails = cartOrderDetails;
    }

    public void insertToCart(Long key, OrderDetail item) {
        boolean bln = cartOrderDetails.containsKey(key);
        if (bln) {
            int quantity_old = item.getQuantity();
            item.setQuantity(quantity_old + 1);
            cartOrderDetails.put(item.getToy().getId(), item);
        } else {
            cartOrderDetails.put(item.getToy().getId(), item);
        }
    }

    public void plusToCart(Long key, OrderDetail item) {
        boolean check = cartOrderDetails.containsKey(key);
        if (check) {
            int quantity_old = item.getQuantity();
            item.setQuantity(quantity_old + 1);
            cartOrderDetails.put(key, item);
        } else {
            cartOrderDetails.put(key, item);
        }
    }

    // sub to cart
    public void subToCart(Long key, OrderDetail item) {
        boolean check = cartOrderDetails.containsKey(key);
        if (check) {
            int quantity_old = item.getQuantity();
            if (quantity_old <= 1) {
                cartOrderDetails.remove(key);
            } else {
                item.setQuantity(quantity_old - 1);
                cartOrderDetails.put(key, item);
            }
        }
    }

    // remove to cart
    public void removeToCart(Long key) {
        boolean check = cartOrderDetails.containsKey(key);
        if (check) {
            cartOrderDetails.remove(key);
        }
    }

    // count item
    public int countOrderDetail() {
        return cartOrderDetails.size();
    }

    // sum total
    public long totalCart() {
        long count = 0;
        // count = price * quantity
        for (Map.Entry<Long, OrderDetail> list : cartOrderDetails.entrySet()) {
            count += list.getValue().getToy().getPrice() * list.getValue().getQuantity();
        }
        return count;
    }

}
