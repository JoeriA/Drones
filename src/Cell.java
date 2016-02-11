import java.util.ArrayList;
import java.util.List;

/**
 * @author L.J.R. Weijs
 * This Cell Class represents a Cell in the World matrix. The characterstics of the Cell is described by the x and y value
 * of the point in space of the matrix. But also the amount of wealth it has, the creatures that are located in the cell
 * and to which world this Cell belongs.
 * Created by laure on 2/1/2016.
 */
public class Cell{
    // initialisation
    private int x;
    private int y;
    private World w;

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

    }

    // ****** GETTERS

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

}
