package myGame.model;

/**
 * An interface to represent the direction of movement in the labyrinth game.
 */
public interface Direction {

    /**
     * Returns the number of rows changing vertically.
     * @return the change vertically
     */
    int getRowChange();

    /**
     * Returns the number of columns changing horizontally.
     * @return the change horizontally
     */
    int getColChange();

}
