/**
 * This Class represents a warehouse on the grid. It contains stock in a 2-dimensional array and a location.
 * Created by laure on 2/11/2016.
 */

import java.util.ArrayList;

public class Warehouse {
    private Cell location;
    private ArrayList<ArrayList<Product>> currentProductStock;
    private ArrayList<Order> assignedOrders;
    private ArrayList<Integer> productsStillNeeded;
    private final int idWarehouse;

    /**
     * The constructor stores the location and initial stock of the warehouse.
     * @param location Cell object with the x- and y-coordinate of the Cell of the grid the warehouse is in
     * @param initialStock 2-dimensional Array with all products initially in stock in the form of all Product objects
     *                     of one type in one Array. Cell 0 corresponds to an Array with all products of type 0.
     */
    public Warehouse(Cell location, ArrayList<ArrayList<Product>> initialStock, int idWarehouse){
        this.location = location;
        currentProductStock = initialStock;
        this.idWarehouse = idWarehouse;
    }

    /**
     * This method adds a product to the stock. First the ID (which is the type) is retrieved, with which the
     * Array containing all types of the same product in the current stock is retrieved.
     * The product is added to this Array, and the Array is placed back in the current stock.
     * @param p the product that is added to the current stock of the warehouse
     */
    public void addProduct(Product p) {
       int id = p.getProductId();
        ArrayList<Product> productType = currentProductStock.get(id);
        productType.add(p);
        currentProductStock.set(id, productType);
    }
    /**
     * This method removes a product from the stock. First the ID (which is the type) is retrieved, with which the
     * Array containing all types of the same product in the current stock is retrieved.
     * One product is removed from this Array, and the Array is placed back in the current stock.
     * @param p the product that is removed from the current stock of the warehouse
     */
    public void removeProduct(Product p) {
        int id = p.getProductId();
        ArrayList<Product> productType = currentProductStock.get(id);
        productType.remove(p);
        currentProductStock.set(id,productType);
    }

    /**
     * This method adds an order to the assigned order list.
     * @param o the order that needs to be added to the order list
     */
    public void addOrder(Order o) {
        assignedOrders.add(o);
    }

    /**
     * This method sets the amount of products of a certain type (id) that is still needed.
     * @param id type of the product
     * @param value the new amount of products of type id that are needed
     */
    public void setProductsStillNeeded(int id, int value) {
        productsStillNeeded.set(id, value);
    }
}
