package myGame.model;

import javafx.beans.property.ObjectProperty;

import java.util.*;

public class BoardGameModel {

    public static int BOARD_SIZE = 7;

    private final Piece[] pieces;

    public BoardGameModel() {
        this(new Piece(new Position(1,4 )));
    }

    public BoardGameModel(Piece... pieces) {
        checkPieces(pieces);
        this.pieces = pieces.clone();
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

    public int getPieceCount() {
        return pieces.length;
    }

    public Position getPiecePosition(int pieceNumber) {
        return pieces[pieceNumber].getPosition();
    }

    public ObjectProperty<Position> positionProperty(int pieceNumber) {
        return pieces[pieceNumber].positionProperty();
    }

    public boolean isValidMove(int pieceNumber, PawnDirection direction) {
        if (pieceNumber < 0 || pieceNumber >= pieces.length) {
            throw new IllegalArgumentException();
        }
        Position newPosition = pieces[pieceNumber].getPosition().moveTo(direction);
        if (! isOnBoard(newPosition)) {
            return false;
        }
        for (var piece : pieces) {
            if (piece.getPosition().equals(newPosition)) {
                return false;
            }
        }
        if(pieces[pieceNumber].getPosition().equals(new Position(0,4))){
            System.out.println("TESZT");
        }

        return true;
    }

    public Set<PawnDirection> getValidMoves(int pieceNumber) {
        EnumSet<PawnDirection> validMoves = EnumSet.noneOf(PawnDirection.class);
        for (var direction : PawnDirection.values()) {
            if (isValidMove(pieceNumber, direction) && pieces[pieceNumber].getPosition().equals(new Position(0,4))) {
                validMoves.add(PawnDirection.DOWN);
                validMoves.add(PawnDirection.RIGHT);
            }
            else if (isValidMove(pieceNumber, direction) && pieces[pieceNumber].getPosition().equals(new Position(0,3))) {
                validMoves.add(PawnDirection.DOWN);
                validMoves.add(PawnDirection.LEFT);
            }
            else if (isValidMove(pieceNumber, direction) && pieces[pieceNumber].getPosition().equals(new Position(0,6))) {
                validMoves.add(PawnDirection.LEFT);
            }
            else if (isValidMove(pieceNumber, direction) && pieces[pieceNumber].getPosition().equals(new Position(1,6))) {
                validMoves.add(PawnDirection.LEFT);
                validMoves.add(PawnDirection.DOWN);
            }
            else if (isValidMove(pieceNumber, direction) && pieces[pieceNumber].getPosition().equals(new Position(0,0))) {
                validMoves.add(PawnDirection.DOWN);
            }
            else if (isValidMove(pieceNumber, direction) && pieces[pieceNumber].getPosition().equals(new Position(0,1))) {
                validMoves.add(PawnDirection.DOWN);
                validMoves.add(PawnDirection.RIGHT);
            }
            else if (isValidMove(pieceNumber, direction) && pieces[pieceNumber].getPosition().equals(new Position(0,2))) {
                validMoves.add(PawnDirection.LEFT);
                validMoves.add(PawnDirection.RIGHT);
            }
            else if (isValidMove(pieceNumber, direction)){
                validMoves.add(direction);
            }
        }
        return validMoves;
    }

    public void move(int pieceNumber, PawnDirection direction) {
        pieces[pieceNumber].moveTo(direction);
    }

    public static boolean isOnBoard(Position position) {
        return 0 <= position.row() && position.row() < BOARD_SIZE
                && 0 <= position.col() && position.col() < BOARD_SIZE;
    }

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
    }

    public static void main(String[] args) {
        BoardGameModel model = new BoardGameModel();
        System.out.println(model);
    }

}
