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
    private int currentTurn;

    public Order(Cell orderDestination,int[] initialRequest){
        isCompleted = false;
        this.initialRequest = initialRequest;
    }

    /**
     * This method will receive the order from the drone
     * @param Order The products which the Drone will give to the cell.
     * @param turn
     */
    public void receiveOrder(ArrayList<ArrayList<Product>> Order, int turn){
        currentTurn = turn;

        // Handle the order
        for (int i = 0; i < initialRequest.length ; i++) {
            stillNeeded[i] = initialRequest[i] - Order.get(i).size();
        }

        // Checks also if the the Order is completed
        checkComplete();
    }

    /**
     * This method will be accessed after each delivery to check if the order has been completed.
     * @return
     */
    public boolean checkComplete(){
        for(int productIDNeeded : stillNeeded){
            if (productIDNeeded != 0){
                return false;
            }
        }
        turnCompleted = currentTurn;
        return true;
    }
}
