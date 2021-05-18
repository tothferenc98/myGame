package myGame.model;

import org.tinylog.Logger;
import java.util.*;

/**
 * This class contains the data and methods of the model.
 */
public class BoardGameModel {
    public Position circlePosition = new Position(1,4);

    public static int BOARD_SIZE = 7;

    public BoardGameModel() {}


    /**
     * Move {@code direction} direction as long as valid for the step.
     * @param direction the direction of the player
     */
    public void move(PawnDirection direction){
        while(true){
            var validMoves = getValidMoves();
            if(validMoves.contains(direction)){
                circlePosition=circlePosition.moveTo(direction);
            }
            else {
                break;
            }

        }

    }

    /**
     * It checks if we can move {@code direction} or if the track is over.
     * @param direction the direction of the player
     * @return returns a true or false value about whether the step is valid
     */
    public boolean isValidMove(PawnDirection direction) {

        Position newPosition = circlePosition.moveTo(direction);
        if (! isOnBoard(newPosition)) {
            return false;
        }

        return true;
    }

    /**
     * Checks the directions in which the model is allowed to move in the given position.
     * @return Returns the arraylist of valid steps
     */
    public ArrayList<PawnDirection> getValidMoves() {
        ArrayList<PawnDirection> validMoves = new ArrayList();
        for (var direction : PawnDirection.values()) {
            if (isValidMove(direction) && circlePosition.equals(new Position(0,0))) {
                validMoves.clear();
                validMoves.add(PawnDirection.DOWN);
            }
            else if (isValidMove(direction) && circlePosition.equals(new Position(0,1))) {
                validMoves.clear();
                validMoves.add(PawnDirection.DOWN);
                validMoves.add(PawnDirection.RIGHT);
            }
            else if (isValidMove(direction) && circlePosition.equals(new Position(0,2))) {
                validMoves.clear();
                validMoves.add(PawnDirection.LEFT);
                validMoves.add(PawnDirection.RIGHT);
            }
            else if (isValidMove(direction) && circlePosition.equals(new Position(0,3))) {
                validMoves.clear();
                validMoves.add(PawnDirection.DOWN);
                validMoves.add(PawnDirection.LEFT);
            }
            else  if (isValidMove(direction) && circlePosition.equals(new Position(0,4))) {
                validMoves.clear();
                validMoves.add(PawnDirection.DOWN);
                validMoves.add(PawnDirection.RIGHT);
            }
            else if (isValidMove(direction) && circlePosition.equals(new Position(0,6))) {
                validMoves.clear();
                validMoves.add(PawnDirection.LEFT);
            }
            else if (isValidMove(direction) && circlePosition.equals(new Position(1,2))) {
                validMoves.clear();
                validMoves.add(PawnDirection.LEFT);
                validMoves.add(PawnDirection.RIGHT);
                validMoves.add(PawnDirection.DOWN);
            }
            else if (isValidMove(direction) && circlePosition.equals(new Position(1,6))) {
                validMoves.clear();
                validMoves.add(PawnDirection.LEFT);
                validMoves.add(PawnDirection.DOWN);
            }
            else if (isValidMove(direction) && circlePosition.equals(new Position(2,1))) {
                validMoves.clear();
                validMoves.add(PawnDirection.LEFT);
                validMoves.add(PawnDirection.UP);
                validMoves.add(PawnDirection.RIGHT);
            }
            else if (isValidMove(direction) && circlePosition.equals(new Position(2,2))) {
                validMoves.clear();
                validMoves.add(PawnDirection.LEFT);
                validMoves.add(PawnDirection.UP);
                validMoves.add(PawnDirection.DOWN);
            }
            else if (isValidMove(direction) && circlePosition.equals(new Position(2,3))) {
                validMoves.clear();
                validMoves.add(PawnDirection.RIGHT);
                validMoves.add(PawnDirection.UP);
                validMoves.add(PawnDirection.DOWN);
            }
            else if (isValidMove(direction) && circlePosition.equals(new Position(2,5))) {
                validMoves.clear();
                validMoves.add(PawnDirection.LEFT);
                validMoves.add(PawnDirection.UP);
                validMoves.add(PawnDirection.DOWN);
            }
            else if (isValidMove(direction) && circlePosition.equals(new Position(2,6))) {
                validMoves.clear();
                validMoves.add(PawnDirection.UP);
                validMoves.add(PawnDirection.DOWN);
            }
            else if (isValidMove(direction) && circlePosition.equals(new Position(3,1))) {
                validMoves.clear();
                validMoves.add(PawnDirection.DOWN);
                validMoves.add(PawnDirection.LEFT);
                validMoves.add(PawnDirection.RIGHT);
            }
            else if (isValidMove(direction) && circlePosition.equals(new Position(3,3))) {
                validMoves.clear();
                validMoves.add(PawnDirection.UP);
                validMoves.add(PawnDirection.LEFT);
            }
            else if (isValidMove(direction) && circlePosition.equals(new Position(3,4))) {
                validMoves.clear();
                validMoves.add(PawnDirection.UP);
                validMoves.add(PawnDirection.DOWN);
            }
            else if (isValidMove(direction) && circlePosition.equals(new Position(3,5))) {
                validMoves.clear();
                validMoves.add(PawnDirection.UP);
                validMoves.add(PawnDirection.DOWN);
                validMoves.add(PawnDirection.RIGHT);
            }
            else if (isValidMove(direction) && circlePosition.equals(new Position(4,0))) {
                validMoves.clear();
                validMoves.add(PawnDirection.RIGHT);
                validMoves.add(PawnDirection.UP);
            }
            else if (isValidMove(direction) && circlePosition.equals(new Position(4,3))) {
                validMoves.clear();
                validMoves.add(PawnDirection.RIGHT);
                validMoves.add(PawnDirection.DOWN);
                validMoves.add(PawnDirection.LEFT);
            }
            else if (isValidMove(direction) && circlePosition.equals(new Position(4,4))) {
                validMoves.clear();
                validMoves.add(PawnDirection.RIGHT);
                validMoves.add(PawnDirection.UP);
                validMoves.add(PawnDirection.LEFT);
            }
            else if (isValidMove(direction) && circlePosition.equals(new Position(4,6))) {
                validMoves.clear();
                validMoves.add(PawnDirection.DOWN);
                validMoves.add(PawnDirection.LEFT);
            }
            else if (isValidMove(direction) && circlePosition.equals(new Position(3,6))) {
                validMoves.clear();
                validMoves.add(PawnDirection.UP);
                validMoves.add(PawnDirection.LEFT);
            }
            else if (isValidMove(direction) && circlePosition.equals(new Position(5,0))) {
                validMoves.clear();
                validMoves.add(PawnDirection.DOWN);
                validMoves.add(PawnDirection.RIGHT);
            }
            else if (isValidMove(direction) && circlePosition.equals(new Position(5,1))) {
                validMoves.clear();
                validMoves.add(PawnDirection.UP);
                validMoves.add(PawnDirection.LEFT);
                validMoves.add(PawnDirection.DOWN);
            }
            else if (isValidMove(direction) && circlePosition.equals(new Position(5,2))) {
                Logger.info("Victory");

            }
            else if (isValidMove(direction) && circlePosition.equals(new Position(5,3))) {
                validMoves.clear();
                validMoves.add(PawnDirection.UP);
                validMoves.add(PawnDirection.RIGHT);
                validMoves.add(PawnDirection.DOWN);
            }
            else if (isValidMove(direction) && circlePosition.equals(new Position(5,4))) {
                validMoves.clear();
                validMoves.add(PawnDirection.RIGHT);
                validMoves.add(PawnDirection.LEFT);
                validMoves.add(PawnDirection.DOWN);
            }
            else if (isValidMove(direction) && circlePosition.equals(new Position(6,2))) {
                validMoves.clear();
                validMoves.add(PawnDirection.RIGHT);
                validMoves.add(PawnDirection.LEFT);
            }
            else if (isValidMove(direction) && circlePosition.equals(new Position(6,3))) {
                validMoves.clear();
                validMoves.add(PawnDirection.UP);
                validMoves.add(PawnDirection.LEFT);
            }
            else if (isValidMove(direction) && circlePosition.equals(new Position(6,4))) {
                validMoves.clear();
                validMoves.add(PawnDirection.UP);
                validMoves.add(PawnDirection.RIGHT);
            }
            else if (isValidMove(direction) && circlePosition.equals(new Position(6,5))) {
                validMoves.clear();
                validMoves.add(PawnDirection.UP);
                validMoves.add(PawnDirection.LEFT);
            }
            else if (isValidMove(direction) && circlePosition.equals(new Position(6,6))) {
                validMoves.clear();
                validMoves.add(PawnDirection.UP);
            }
            else if (isValidMove(direction)){
                validMoves.add(direction);
            }
        }
        return validMoves;
    }

    /**
     * Returns whether the model is on the board in the given {@code position} position.
     * @param position The position of the model is given as a parameter
     * @return Returns whether it is on the board as a true or false value
     */
    public static boolean isOnBoard(Position position) {
        return 0 <= position.row() && position.row() < BOARD_SIZE
                && 0 <= position.col() && position.col() < BOARD_SIZE;
    }

    public static void main(String[] args) {
        /*
        BoardGameModel model = new BoardGameModel();
        System.out.println(model + "dasdadsd");
        model.move(PawnDirection.DOWN);
        System.out.println(model.circlePosition.toString());
        */
    }
}
