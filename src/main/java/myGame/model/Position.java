package myGame.model;

import java.util.Objects;

/**
 * Record class for representing a position on the gameboard.
 */
public record Position(int row, int col) {

    /**
     * Moving the {@code Position} object to the direction of {@code direction}.
     * @param direction the direction to move to
     * @return the new {@code Position} object with the right position
     */
    public Position moveTo(Direction direction) {
        return new Position(row + direction.getRowChange(), col + direction.getColChange());
    }

    /**
     * Convert row and column values (row, col) to String format.
     * @return the row and column values in String format.
     */
    public String toString() {
        return String.format("(%d,%d)", row, col);
    }

    /**
     * Checks if the two objects are equal
     * @param o object
     * @return a true or false value depending on whether they equals
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return row == position.row && col == position.col;
    }


}