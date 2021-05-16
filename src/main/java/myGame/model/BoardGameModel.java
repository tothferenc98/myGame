package myGame.model;

import javafx.beans.property.ObjectProperty;
import org.tinylog.Logger;
import java.util.*;

public class BoardGameModel {
    public Position circlePosition = new Position(1,4);

    public static int BOARD_SIZE = 7;



    public BoardGameModel() {

    }

    public BoardGameModel(Piece... pieces) {
        checkPieces(pieces);
    }

    public void move(PawnDirection direction){
        while(true){
            //golyoPosition=golyoPosition(moveTo(direction))
            var teszt = getValidMoves();
            if(teszt.contains(direction)){
                //System.out.println("move TESZT");
                circlePosition=circlePosition.moveTo(direction);
            }
            else {
                break;
            }

        }

    }

    private void checkPieces(Piece[] pieces) {
        var seen = new HashSet<Position>();
        for (var piece : pieces) {
            if (! isOnBoard(piece.getPosition()) || seen.contains(piece.getPosition())) {
                throw new IllegalArgumentException();
            }
            seen.add(piece.getPosition());
        }
    }
/*
    public int getPieceCount() {
        return pieces.length;
    }

    public Position getPiecePosition(int pieceNumber) {
        return pieces[pieceNumber].getPosition();
    }

    public ObjectProperty<Position> positionProperty(int pieceNumber) {
        return pieces[pieceNumber].positionProperty();
    }*/

    public boolean isValidMove(PawnDirection direction) {

        Position newPosition = circlePosition.moveTo(direction);
        if (! isOnBoard(newPosition)) {
            return false;
        }

        return true;
    }

    public ArrayList<PawnDirection> getValidMoves() {
        ArrayList<PawnDirection> validMoves = new ArrayList();

        for (var direction : PawnDirection.values()) {
            if (isValidMove(direction) && circlePosition.equals(new Position(0,0))) {
                validMoves.add(PawnDirection.DOWN);
            }
            else if (isValidMove(direction) && circlePosition.equals(new Position(0,1))) {
                validMoves.add(PawnDirection.DOWN);
                validMoves.add(PawnDirection.RIGHT);
            }
            else if (isValidMove(direction) && circlePosition.equals(new Position(0,2))) {
                validMoves.add(PawnDirection.LEFT);
                validMoves.add(PawnDirection.RIGHT);
            }
            else if (isValidMove(direction) && circlePosition.equals(new Position(0,3))) {
                validMoves.add(PawnDirection.DOWN);
                validMoves.add(PawnDirection.LEFT);
            }
            else  if (isValidMove(direction) && circlePosition.equals(new Position(0,4))) {
                validMoves.add(PawnDirection.DOWN);
                validMoves.add(PawnDirection.RIGHT);
            }
            else if (isValidMove(direction) && circlePosition.equals(new Position(0,6))) {
                validMoves.add(PawnDirection.LEFT);
            }
            else if (isValidMove(direction) && circlePosition.equals(new Position(1,2))) {
                validMoves.add(PawnDirection.LEFT);
                validMoves.add(PawnDirection.RIGHT);
                validMoves.add(PawnDirection.DOWN);
            }
            else if (isValidMove(direction) && circlePosition.equals(new Position(1,6))) {
                validMoves.add(PawnDirection.LEFT);
                validMoves.add(PawnDirection.DOWN);
            }
            else if (isValidMove(direction) && circlePosition.equals(new Position(2,1))) {
                validMoves.add(PawnDirection.LEFT);
                validMoves.add(PawnDirection.UP);
                validMoves.add(PawnDirection.RIGHT);
            }
            else if (isValidMove(direction) && circlePosition.equals(new Position(2,2))) {
                validMoves.add(PawnDirection.LEFT);
                validMoves.add(PawnDirection.UP);
                validMoves.add(PawnDirection.DOWN);
            }
            else if (isValidMove(direction) && circlePosition.equals(new Position(2,3))) {
                validMoves.add(PawnDirection.RIGHT);
                validMoves.add(PawnDirection.UP);
                validMoves.add(PawnDirection.DOWN);
            }
            else if (isValidMove(direction) && circlePosition.equals(new Position(2,5))) {
                validMoves.add(PawnDirection.LEFT);
                validMoves.add(PawnDirection.UP);
                validMoves.add(PawnDirection.DOWN);
            }
            else if (isValidMove(direction) && circlePosition.equals(new Position(2,6))) {
                validMoves.add(PawnDirection.UP);
                validMoves.add(PawnDirection.DOWN);
            }
            else if (isValidMove(direction) && circlePosition.equals(new Position(3,1))) {
                validMoves.add(PawnDirection.DOWN);
                validMoves.add(PawnDirection.LEFT);
                validMoves.add(PawnDirection.RIGHT);
            }
            else if (isValidMove(direction) && circlePosition.equals(new Position(3,3))) {
                validMoves.add(PawnDirection.UP);
                validMoves.add(PawnDirection.LEFT);
            }
            else if (isValidMove(direction) && circlePosition.equals(new Position(3,4))) {
                validMoves.add(PawnDirection.UP);
                validMoves.add(PawnDirection.DOWN);
            }
            else if (isValidMove(direction) && circlePosition.equals(new Position(3,5))) {
                validMoves.add(PawnDirection.UP);
                validMoves.add(PawnDirection.DOWN);
                validMoves.add(PawnDirection.RIGHT);
            }
            else if (isValidMove(direction) && circlePosition.equals(new Position(4,0))) {
                validMoves.add(PawnDirection.RIGHT);
                validMoves.add(PawnDirection.UP);
            }
            else if (isValidMove(direction) && circlePosition.equals(new Position(4,3))) {
                validMoves.add(PawnDirection.RIGHT);
                validMoves.add(PawnDirection.DOWN);
                validMoves.add(PawnDirection.LEFT);
            }
            else if (isValidMove(direction) && circlePosition.equals(new Position(4,4))) {
                validMoves.add(PawnDirection.RIGHT);
                validMoves.add(PawnDirection.UP);
                validMoves.add(PawnDirection.LEFT);
            }
            else if (isValidMove(direction) && circlePosition.equals(new Position(4,6))) {
                validMoves.add(PawnDirection.DOWN);
                validMoves.add(PawnDirection.LEFT);
            }
            else if (isValidMove(direction) && circlePosition.equals(new Position(3,6))) {
                validMoves.add(PawnDirection.UP);
                validMoves.add(PawnDirection.LEFT);
            }
            else if (isValidMove(direction) && circlePosition.equals(new Position(5,0))) {
                validMoves.add(PawnDirection.DOWN);
                validMoves.add(PawnDirection.RIGHT);
            }
            else if (isValidMove(direction) && circlePosition.equals(new Position(5,1))) {
                validMoves.add(PawnDirection.UP);
                validMoves.add(PawnDirection.LEFT);
                validMoves.add(PawnDirection.DOWN);
            }
            else if (isValidMove(direction) && circlePosition.equals(new Position(5,2))) {
                Logger.info("");

            }
            else if (isValidMove(direction) && circlePosition.equals(new Position(5,3))) {
                validMoves.add(PawnDirection.UP);
                validMoves.add(PawnDirection.RIGHT);
                validMoves.add(PawnDirection.DOWN);
            }
            else if (isValidMove(direction) && circlePosition.equals(new Position(5,4))) {
                validMoves.add(PawnDirection.RIGHT);
                validMoves.add(PawnDirection.LEFT);
                validMoves.add(PawnDirection.DOWN);
            }
            else if (isValidMove(direction) && circlePosition.equals(new Position(5,4))) {
                validMoves.add(PawnDirection.RIGHT);
                validMoves.add(PawnDirection.LEFT);
                validMoves.add(PawnDirection.DOWN);
            }
            else if (isValidMove(direction) && circlePosition.equals(new Position(6,2))) {
                validMoves.add(PawnDirection.RIGHT);
                validMoves.add(PawnDirection.LEFT);
            }
            else if (isValidMove(direction) && circlePosition.equals(new Position(6,3))) {
                validMoves.add(PawnDirection.UP);
                validMoves.add(PawnDirection.LEFT);
            }
            else if (isValidMove(direction) && circlePosition.equals(new Position(6,4))) {
                validMoves.add(PawnDirection.UP);
                validMoves.add(PawnDirection.RIGHT);
            }
            else if (isValidMove(direction) && circlePosition.equals(new Position(6,5))) {
                validMoves.add(PawnDirection.UP);
                validMoves.add(PawnDirection.LEFT);
            }
            else if (isValidMove(direction) && circlePosition.equals(new Position(6,6))) {
                validMoves.add(PawnDirection.UP);
            }
            else if (isValidMove(direction)){
                validMoves.add(direction);
            }
        }
        return validMoves;
    }
/*
    public void move(int pieceNumber, PawnDirection direction) {
        pieces[pieceNumber].moveTo(direction);
    }*/

    public static boolean isOnBoard(Position position) {
        return 0 <= position.row() && position.row() < BOARD_SIZE
                && 0 <= position.col() && position.col() < BOARD_SIZE;
    }
/*
    public List<Position> getPiecePositions() {
        List<Position> positions = new ArrayList<>(pieces.length);
        for (var piece : pieces) {
            positions.add(piece.getPosition());
        }
        return positions;
    }

    public OptionalInt getPieceNumber(Position position) {
        for (int i = 0; i < pieces.length; i++) {
            if (pieces[i].getPosition().equals(position)) {
                return OptionalInt.of(i);
            }
        }
        return OptionalInt.empty();
    }

    public String toString() {
        StringJoiner joiner = new StringJoiner(",", "[", "]");
        for (var piece : pieces) {
            joiner.add(piece.toString());
        }
        return joiner.toString();
    }*/

    public static void main(String[] args) {
        BoardGameModel model = new BoardGameModel();
        //System.out.println(model + "dasdadsd");
        //model.move(PawnDirection.DOWN);
        //System.out.println(model.circlePosition.toString());


    }

}
