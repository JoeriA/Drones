import java.util.ArrayList;

/**
 * Created by Joeri on 11-2-2016.
 */
public class Dataset {

    private ArrayList<Drone> drones;
    private ArrayList<Order> orders;
    private ArrayList<Warehouse> warehouses;
    private World world;

    public Dataset() {

    }

    public ArrayList<Drone> getDrones() {
        return drones;
    }

    public void setDrones(ArrayList<Drone> drones) {
        this.drones = drones;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public ArrayList<Warehouse> getWarehouses() {
        return warehouses;
    }

    public void setWarehouses(ArrayList<Warehouse> warehouses) {
        this.warehouses = warehouses;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }
}
