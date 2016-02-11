/**
 * Created by laure on 2/11/2016.
 */
public class Product {
    private int weight;
    private int id;

    /**
     * Constructor of a Product.
     */
    public Product(int weight, int id){
        this.weight = weight;
        this.id = id;
    }

    /**
     * This method gets the id of the product.
     * @return the id of the product
     */
    public int getProductId() {
        return id;
    }
}
