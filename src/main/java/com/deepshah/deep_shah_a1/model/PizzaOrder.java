package com.deepshah.deep_shah_a1.model;

/**
 * This class includes the details of the order i.e. price, topping,size and 
 * if the order is delivery or pick up.
 * 
 * @author Deep Shah
 */
public class PizzaOrder {

    private String[] toppings;
    private String size;
    private boolean delivery;

 
    /**
     * Default constructor
     */
    public PizzaOrder() {   
    }

    public String[] getToppings() {
        return toppings;
    }

    public void setToppings(String[] toppings) {
        this.toppings = toppings;
    }

    public String getSize() {

        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public boolean isDelivery() {
        return delivery;
    }

    public void setDelivery(boolean delivery) {
        this.delivery = delivery;
    }

    /**
     * 
     * @return the price of the pizza 
     */
    public double getPrice() {

        double price = 0;
        switch (size) {
            case "Small": // small pizza adds $5
                price = 5;
                break;
            case "Medium":
                price = 7; //medium pizza adds $7
                break;
            default:
                price = 9;//large pizza adds $9
                break;
        }

        //delivery adds $2
        if(delivery){
            price =  price + 2;
        }
        //if toppings is not null then each toppings add $1 i.e. the length of 
        // the array toppings
        if (toppings != null) {
            price = price + toppings.length;
        }
        return price;
    }
}
