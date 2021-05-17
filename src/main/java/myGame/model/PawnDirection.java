package myGame.model;

/**
 * Enum for representing the ball moves in the table.
 */
public enum PawnDirection implements Direction {


    UP(-1, 0),
    RIGHT(0, 1),
    DOWN(1, 0),
    LEFT(0, -1);

    private final int rowChange;
    private final int colChange;

    PawnDirection(int rowChange, int colChange) {
        this.rowChange = rowChange;
        this.colChange = colChange;
    }

    /**
     * Returns the number of rows changing vertically.
     *
     * @return Return the change vertically
     */
    public int getRowChange() {
        return rowChange;
    }

    /**
     * Returns the number of columns changing horizontally.
     *
     * @return Return the change horizontally
     */
    public int getColChange() {
        return colChange;
    }

    public static void main(String[] args) {
        //System.out.println(of(1, -1));
    }

}
