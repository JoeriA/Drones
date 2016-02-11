/**
 * Created by Joeri on 11-2-2016.
 */
public class Solver {

    private Dataset dataset;

    public Solver(Dataset dataset) {
        this.dataset = dataset;
    }

    private void assignOrders() {
        for (Order order : dataset.getOrders()) {
            int[] distances = new int[dataset.getWarehouses().size()];
            int shortestDistance = Integer.MAX_VALUE;
            Warehouse nearestWarehouse = null;
            for (Warehouse warehouse : dataset.getWarehouses()) {
                int distance = getDistance(warehouse.getCell(), order.getCell());
                if (distance < shortestDistance) {
                    shortestDistance = distance;
                    nearestWarehouse = warehouse;
                }
            }
            order.assignWarehouse(nearestWarehouse.getID());
            nearestWarehouse.addOrder(order);
        }
    }

    public static int getDistance(Cell from, Cell to) {
        double distance = Math.sqrt((from.getX() - to.getX()) ^ 2 + (from.getY() - to.getY()) ^ 2);
        int roundedDistance = (int) Math.ceil(distance);
        return (roundedDistance);
    }
}
