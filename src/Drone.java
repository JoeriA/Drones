import java.util.ArrayList;

/**
 * Eventually
 * Created by laure on 2/11/2016.
 */
public class Drone {
    private int droneID;
    private int maxCapacity;
    private ArrayList<ArrayList<Product>> productList;
    private Cell destinationCell;
    private int turnAvailable;
    private String logString;

    /**
     * Constructor of a Drone.
     * @param maxCapacity Maximum Capacity
     * @param startCell the starting cell of this Drone
     */
    public Drone(int maxCapacity, Cell startCell, int droneID){
        this.maxCapacity = maxCapacity;
        destinationCell = startCell;
        turnAvailable = 0;
        productList = new ArrayList<ArrayList<Product>>(4);
        this.droneID = droneID;
        logString = logString + droneID;
    }

    public void load(ArrayList<ArrayList<Product>> products, Cell loadLocation){
        if(loadLocation != destinationCell){
            turnAvailable = turnAvailable + transportCost(destinationCell, loadLocation);
            destinationCell = loadLocation;
            productList = products;
            turnAvailable++;                                // loading costs 1 turn
        } else {
            productList = products;
            turnAvailable++;                                // loading costs 1 turn
        }
    }

    public void deliver(ArrayList<ArrayList<Product>> products, Cell deliverLocation){
        if(deliverLocation != destinationCell){
            turnAvailable = turnAvailable + transportCost(destinationCell, deliverLocation);
            destinationCell = deliverLocation;
            productList = products;
            turnAvailable++;                                // delivering costs 1 turn
        } else {
            productList = products;
            turnAvailable++;                                // delivering costs 1 turn
        }
    }

    public void unload(){


    }

    /**
     *
     * @param turns
     */
    public void waitDrone(int turns){
        turn = turn + turns;
    }

    /**
     * This method will calculate how much turns it will take to travel from cell 1 to cell 2.
     * @param cell1
     * @param cell2
     * @return
     */
    public int transportCost(Cell cell1, Cell cell2){
        double euclidean = Math.sqrt(Math.pow(Math.abs(cell1.getX()-cell2.getX()),2) + Math.pow(Math.abs(cell1.getY() - cell2.getY()),2));

        return (int) Math.ceil(euclidean);
    }

    /**
     *
     * @return
     */
    public String getLogString(){
        return logString;
    }


    public int getTurnAvailable(){
        return turnAvailable;
    }

}
