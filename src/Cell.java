import java.util.ArrayList;
import java.util.List;

/**
 * @author L.J.R. Weijs
 * This Cell Class represents a Cell in the World matrix. The characterstics of the Cell is described by the x and y value
 * of the point in space of the matrix. But also the amount of wealth it has, the creatures that are located in the cell
 * and to which world this Cell belongs.
 * Created by laure on 2/1/2016.
 */
public class Cell implements Comparable<Cell> {
    // initialisation
    public static final int MAX_WEALTH = 100;
    private int x;
    private int y;
    private World w;
    private int wealth;
    private List<Creature> creatureList;

    /**
     * This constructor method makes an instance of the Cell class and initializes it with the world from the world,
     * x-point and y-point.
     * @param w The world in which the Cell is located.
     * @param x The x-point in space in the cartesian coordinate system.
     * @param y The y-point in space in the cartesian coordinate system.
     */
    public Cell(World w, int x, int y){
        this.w = w;
        this.x = x;
        this.y = y;
        wealth = 0;
        creatureList = new ArrayList<Creature>();
    }

    /**
     * This method is used to add a creature to the creatureList of the Cell.
     * @param c a creature
     */
    public void addCreature(Creature c){
        if(c.getCurrentCell() !=  null) {
            c.getCurrentCell().removeCreature(c);
        }
        creatureList.add(c);
    }

    /**
     * This method is used to remove a specific create from the creatureList of the Cell.
     * @param c a creature
     */
    public void removeCreature(Creature c){
        creatureList.remove(c);
    }

    /**
     * This method is used to change the current amount of wealth of the Cell. This wealth an be used by the creatures
     * currently living in a cell for sustenance. Each cell cannot contain more than the MAX_WEALTH and not lower than 0.
     * If it is lower than zero an argument will be thrown.
     * @param amount the amount of points the wealth needs to change with.
     */
    public void changeWealth(int amount){

        if(wealth + amount > MAX_WEALTH ){
            wealth = MAX_WEALTH;
            return;
        }

        if(wealth + amount < 0){
            throw new IllegalArgumentException("When you perform this action the wealth of the cell will reach a critical " +
                    "low level, this is not possible.");
        }

        wealth = wealth + amount;
        return;

    }

    // ****** GETTERS

    /**
     * This accessor method will return the creatureList containing all the creatures living in the current cell.
     * @return a List containing al creaturs from this cell.
     */
    public List<Creature> getCreatures(){
        List<Creature> creatures = new ArrayList<Creature>();
        for(Creature c : creatureList){
            creatures.add(c);
        }
        return (List) creatures;
    }

    /**
     * This accessor method will return the current wealth of the current cell.
     * @return an int representing the wealth of the current cell.
     */
    public int getWealth(){
        return wealth;
    }

    /**
     * This accessor method will return the x position in the cartesian space system of the cell in the current world.
     * @return an int which represents the x position of the Cell.
     */
    public int getX(){
        return x;
    }

    /**
     * This accessor method will return the y position in the cartesian space system of the cell in the current world.
     * @return an int which represents the y position of the Cell.
     */
    public int getY(){
        return y;
    }

    /**
     * This accessor method will return the world where the current Cell is located in.
     * @return
     */
    public World getWorld(){
        return w;
    }

    /**
     * This compareTo method will be Overriden in the Comparable Class. This class will look at the amount of creatures
     * inside the cell. If the amount of creaturs is lower than the the in the other cell it will be favorable.
     * @param o this o is an other instance of a cell.
     * @return it will return a int value where which will be interpretated by the Compare Class
     */
    @Override
    public int compareTo(Cell o) {

        if(creatureList.size() - o.getCreatures().size() == 0){
            return o.getWealth() - wealth;
        }

        return creatureList.size() - o.getCreatures().size();
    }
}
