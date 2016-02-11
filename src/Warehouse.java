/**
 * This Class represents a warehouse on the grid. It contains stock in a 2-dimensional array and a location.
 * Created by laure on 2/11/2016.
 */

import java.util.ArrayList;

public class Warehouse {
    private Cell location;
    private ArrayList<ArrayList<Product>> currentProductStock;

    /**
     * The constructor stores the location and initial stock of the warehouse.
     * @param location Cell object with the x- and y-coordinate of the Cell of the grid the warehouse is in
     * @param initialStock 2-dimensional Array with all products initially in stock in the form of all Product objects
     *                     of one type in one Array. Cell 0 corresponds to an Array with all products of type 0.
     */
    public Warehouse(Cell location, ArrayList<ArrayList<Product>> initialStock){
        this.location = location;
        currentProductStock = initialStock;
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

}
