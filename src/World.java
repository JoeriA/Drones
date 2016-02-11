import java.util.ArrayList;
import java.util.List;

/**
 * @author L.J.R. Weijs
 * This Class represents a world, this world has a size containing the width and height. This world regulated the Cells
 * in it. For further information for a Cell please have a look at the Cell class.
 * Created by laurens on 2/1/2016.
 */
public class World {
    private int width;
    private int height;
    private List<Cell> cellList = new ArrayList<Cell>();

    /**
     * This Constructor makes an empty Map with a given width and height. The World is a Map which is a Key-Value pair
     * based storage List. The Key of the Map will be the coordinates of the Map and the value will be what creature
     * will occupy the value space of the Map.
     * <p>
     * --The world will be from (1,1) to (width, height) in cartesian coordinate
     * system. We will start with 1 to make it easier for the getNeighbours method to work with the modulos.
     *
     * @param w is an integer representing the width of the new World.
     * @param h is an integer representing the length of the new World.
     */
    public World(int w, int h) {
        // initialisation
        width = w;
        height = h;

        // creates new cells, makes in total w*h.
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                cellList.add(new Cell(this, i, j));     // creates an empty Cell and puts it into the cellList
            }
        }

    }

    /**
     * This method will search for the neighbours of the Cell c which is given by the user. There will always be 8
     * neighbours to retrieve. A Neigbour is also a through wall neighbour.
     *
     * @param c is the cell to find the neighbours of and to be returned to the user
     * @return a List of always 8 neighbouring cells, for the given Cell.
     */
    public List<Cell> getNeighbours(Cell c) {
        // initialisation
        int c_x = c.getX();
        int c_y = c.getY();
        List<Cell> neighbours = new ArrayList<Cell>();
        int tempx, tempy;

        if(c_x == width){
            tempx = 0;
        } else{
            tempx = (c_x + 1)%width;
        }

        if(c_y == height){
            tempy = 0;
        }else{
            tempy = (c_y + 1)%height;
        }

        neighbours.add(getCell(((((c_x - 1) % width)+width)%width), ((((c_y - 1) % height)+height)%height)));
        neighbours.add(getCell((c_x) % width, ((((c_y - 1) % height)+height)%height)));
        neighbours.add(getCell(tempx , ((((c_y - 1) % height)+height)%height)));
        neighbours.add(getCell(((((c_x - 1) % width)+width) % width), (c_y) % height));
        neighbours.add(getCell(tempx, (c_y) % height));
        neighbours.add(getCell(((((c_x - 1) % width)+width)%width), tempy));
        neighbours.add(getCell((c_x) % width, tempy));
        neighbours.add(getCell(tempx , tempy));

        return neighbours;

    }

    /**
     * The method will return a List of all the creatures in all the Cells from this World class.
     *
     * @return a List containing Creatures.
     */
    public List<Creature> getCreatures() {
        // initialisation
        ArrayList<Creature> creatures = new ArrayList<Creature>();

        for (Cell cell : cellList) {
            ArrayList<Creature> cellCreatures = (ArrayList) cell.getCreatures();

            for (int i = 0; i < cellCreatures.size(); i++) {
                creatures.add(cellCreatures.get(i));
            }
        }
        return creatures;

    }

    // ****** GETTERS

    /**
     * This accessor method gets the width of the world.
     *
     * @return this int is the width of the current world.
     */
    public int getWidth() {
        return width;
    }

    /**
     * This accessor method gets the height of the world.
     *
     * @return this int is the height of the current world.
     */
    public int getHeight() {
        return height;
    }

    /**
     * This accessor method gets the Cell in the position x, y. When this location is out of bound of the world, an
     * exception will be trown.
     *
     * @param x this is the x - axis of the location of the Cell to be retrieved.
     * @param y this is the y - axis of the location of the Cell to be retrieved.
     * @return this method returns the Cell with the characteristics that it is in this world, and that the x and y
     * location is liked the user assumed with the input variables.
     */
    public Cell getCell(int x, int y) {

        if (x < 0 || y < 0 || x > width || y > height) {
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

