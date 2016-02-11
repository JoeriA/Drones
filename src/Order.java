import java.util.ArrayList;

/**
 * Created by laure on 2/11/2016.
 */
public class Order {
    private Cell orderDestination;
    private int[] stillNeeded;
    private boolean isCompleted;
    private int turnCompleted;
    //private ArrayList<ArrayList<Product>> productReceived;
    private int[] initialRequest;

    public Order(Cell orderDestination,int[] initialRequest){
        isCompleted = false;
        this.initialRequest = initialRequest;
    }

    public checkComplete(){

    }
}
