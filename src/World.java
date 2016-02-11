import java.util.ArrayList;
import java.util.List;

/**
 * @author L.J.R. Weijs
 * This Class represents a world, a grid consisting of cells. The world has
 * a certain width and height, represented by the amount of cells.
 * For further information on a Cell please look at the Cell class.
 * Created by laure on 2/1/2016.
 */
public class World {
    private int maxX;
    private int maxY;
    private List<Cell> cellList = new ArrayList<Cell>();

    /**
     * This Constructor makes an empty grid with a given width and height.
     * <p>
     * --The world will be from (1,1) to (width, height) in cartesian coordinate
     * system. We will start with 1 to make it easier for the getNeighbours method to work with the modulos.
     *
     * @param x is an integer representing the width of the new World.
     * @param y is an integer representing the length of the new World.
     */
    public World(int x, int y) {
        // initialisation
        maxX= x;
        maxY = y;

        // creates new cells, makes in total w*h.
        for (int i = 0; i < maxX; i++) {
            for (int j = 0; j < maxY; j++) {
                cellList.add(new Cell(this, i, j));     // creates an empty Cell and puts it into the cellList
            }
        }

    }
    /**
     * This accessor method gets the width of the world.
     *
     * @return this int is the width of the current world.
     */
    public int getWidth() {
        return maxX;
    }

    /**
     * This accessor method gets the height of the world.
     *
     * @return this int is the height of the current world.
     */
    public int getHeight() {
        return maxY;
    }

    /**
     * This accessor method gets the Cell in the position x, y. When this location is out of bound of the world, an
     * exception will be thrown.
     *
     * @param x this is the x - coordinate of the location of the Cell to be retrieved.
     * @param y this is the y - coordinate of the location of the Cell to be retrieved.
     * @return this method returns the Cell with the characteristics that it is in this world, and that the x and y
     * location is liked the user assumed with the input variables.
     */
    public Cell getCell(int x, int y) {

        if (x < 0 || y < 0 || x > maxX || y > maxY) {
            throw new IllegalArgumentException("The given position (x,y)=(" + x + "," + y + "), is outside of the world. " +
                    "and therefore not valid");
        }

        for (Cell cell : cellList) {
            if (cell.getX() == x && cell.getY() == y) {
                return cell;
            }
        }
        // this should not occur actually.
        System.out.println("Something is terribly wrong with your program, because the Cell you asked for is not available!");
        return null;
    }
}

