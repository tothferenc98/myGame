package myGame;


import myGame.model.PawnDirection;
import myGame.model.Position;
import org.junit.jupiter.api.Test;
import myGame.model.BoardGameModel;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class myGameModelTest {
    BoardGameModel testModel = new BoardGameModel();
    public Position expected;

    @Test
    void testIsOnBoard(){
        assertTrue(testModel.isOnBoard(testModel.circlePosition));
        assertFalse(testModel.isOnBoard(new Position(0,7)));
        assertFalse(testModel.isOnBoard(new Position(-1,6)));
        assertFalse(testModel.isOnBoard(new Position(0,-1)));
        assertFalse(testModel.isOnBoard(new Position(-1,6)));
        assertTrue(testModel.isOnBoard(new Position(0,0)));
        assertTrue(testModel.isOnBoard(new Position(6,6)));
    }

    @Test
    void testIsValidMove(){
        assertTrue(testModel.isValidMove(PawnDirection.LEFT));
        testModel.circlePosition=new Position(-3,0);
        assertFalse(testModel.isValidMove(PawnDirection.LEFT));
    }

    @Test
    void testgetValidMoves(){
        testModel.circlePosition=new Position(5,3);
        ArrayList<PawnDirection> testValidMoves = new ArrayList();
        testValidMoves.add(PawnDirection.UP);
        testValidMoves.add(PawnDirection.RIGHT);
        testValidMoves.add(PawnDirection.DOWN);
        assertEquals(testValidMoves, testModel.getValidMoves());
    }

    @Test
    void testMove(){
        expected= new Position(1,0);
        testModel.move(PawnDirection.LEFT);
        assertEquals(expected ,testModel.circlePosition);
    }



}
