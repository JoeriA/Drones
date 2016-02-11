import java.util.ArrayList;

/**
 * Eventually
 * Created by laure on 2/11/2016.
 */
public class Drone {
    private int maxCapacity;
    private ArrayList<ArrayList<Product>> productList;
    private int destinationCell;
    private int turn;

    /**
     * Constructor of a Drone.
     * @param maxCapacity Maximum Capacity
     * @param startCell the starting cell of this Drone
     */
    public Drone(int maxCapacity, int startCell){
        this.maxCapacity = maxCapacity;
        destinationCell = startCell;
        turn = 0;
        productList = new ArrayList<ArrayList<Product>>(4);
    }

    public void load(ArrayList<ArrayList<Product>> products,  ){

    }

    public void deliver(){

    }

    public void unload(){
        if()

    }

    public void waitDrone(){

    }

    public static void calculateEuclidian(){

    }

}
