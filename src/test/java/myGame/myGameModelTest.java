package myGame;


import myGame.model.PawnDirection;
import myGame.model.Position;
import org.junit.jupiter.api.Test;
import myGame.model.BoardGameModel;
import org.tinylog.Logger;

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
        testModel.circlePosition=new Position(0,0);
        ArrayList<PawnDirection> testValidMoves = new ArrayList();
        testValidMoves.add(PawnDirection.DOWN);
        assertEquals(testValidMoves, testModel.getValidMoves());

        testModel.circlePosition=new Position(0,1);
        testValidMoves.clear();
        testValidMoves.add(PawnDirection.DOWN);
        testValidMoves.add(PawnDirection.RIGHT);
        assertEquals(testValidMoves, testModel.getValidMoves());

        testModel.circlePosition=new Position(0,2);
        testValidMoves.clear();
        testValidMoves.add(PawnDirection.LEFT);
        testValidMoves.add(PawnDirection.RIGHT);
        assertEquals(testValidMoves, testModel.getValidMoves());

        testModel.circlePosition=new Position(0,3);
        testValidMoves.clear();
        testValidMoves.add(PawnDirection.DOWN);
        testValidMoves.add(PawnDirection.LEFT);
        assertEquals(testValidMoves, testModel.getValidMoves());

        testModel.circlePosition=new Position(0,4);
        testValidMoves.clear();
        testValidMoves.add(PawnDirection.DOWN);
        testValidMoves.add(PawnDirection.RIGHT);
        assertEquals(testValidMoves, testModel.getValidMoves());

        testModel.circlePosition=new Position(0,5);
        testValidMoves.clear();
        testValidMoves.add(PawnDirection.RIGHT);
        testValidMoves.add(PawnDirection.DOWN);
        testValidMoves.add(PawnDirection.LEFT);
        assertEquals(testValidMoves, testModel.getValidMoves());

        testModel.circlePosition=new Position(0,6);
        testValidMoves.clear();
        testValidMoves.add(PawnDirection.LEFT);
        assertEquals(testValidMoves, testModel.getValidMoves());

        testModel.circlePosition=new Position(1,0);
        testValidMoves.clear();
        testValidMoves.add(PawnDirection.UP);
        testValidMoves.add(PawnDirection.RIGHT);
        testValidMoves.add(PawnDirection.DOWN);
        assertEquals(testValidMoves, testModel.getValidMoves());

        testModel.circlePosition=new Position(1,1);
        testValidMoves.clear();
        testValidMoves.add(PawnDirection.UP);
        testValidMoves.add(PawnDirection.RIGHT);
        testValidMoves.add(PawnDirection.DOWN);
        testValidMoves.add(PawnDirection.LEFT);
        assertEquals(testValidMoves, testModel.getValidMoves());

        testModel.circlePosition=new Position(1,2);
        testValidMoves.clear();
        testValidMoves.add(PawnDirection.LEFT);
        testValidMoves.add(PawnDirection.RIGHT);
        testValidMoves.add(PawnDirection.DOWN);
        assertEquals(testValidMoves, testModel.getValidMoves());

        testModel.circlePosition=new Position(1,6);
        testValidMoves.clear();
        testValidMoves.add(PawnDirection.LEFT);
        testValidMoves.add(PawnDirection.DOWN);
        assertEquals(testValidMoves, testModel.getValidMoves());


        testModel.circlePosition=new Position(2,1);
        testValidMoves.clear();
        testValidMoves.add(PawnDirection.DOWN);
        assertNotEquals(testValidMoves, testModel.getValidMoves());

        testModel.circlePosition=new Position(2,2);
        testValidMoves.clear();
        testValidMoves.add(PawnDirection.RIGHT);
        assertNotEquals(testValidMoves, testModel.getValidMoves());

        testModel.circlePosition=new Position(2,3);
        testValidMoves.clear();
        testValidMoves.add(PawnDirection.LEFT);
        assertNotEquals(testValidMoves, testModel.getValidMoves());

        testModel.circlePosition=new Position(2,5);
        testValidMoves.clear();
        testValidMoves.add(PawnDirection.RIGHT);
        assertNotEquals(testValidMoves, testModel.getValidMoves());

        testModel.circlePosition=new Position(2,6);
        testValidMoves.clear();
        testValidMoves.add(PawnDirection.RIGHT);
        assertNotEquals(testValidMoves, testModel.getValidMoves());

        testModel.circlePosition=new Position(3,1);
        testValidMoves.clear();
        testValidMoves.add(PawnDirection.DOWN);
        testValidMoves.add(PawnDirection.LEFT);
        testValidMoves.add(PawnDirection.RIGHT);
        assertEquals(testValidMoves, testModel.getValidMoves());

        testModel.circlePosition=new Position(3,3);
        testValidMoves.clear();
        testValidMoves.add(PawnDirection.UP);
        testValidMoves.add(PawnDirection.LEFT);
        assertEquals(testValidMoves, testModel.getValidMoves());

        testModel.circlePosition=new Position(3,4);
        testValidMoves.clear();
        testValidMoves.add(PawnDirection.UP);
        testValidMoves.add(PawnDirection.DOWN);
        assertEquals(testValidMoves, testModel.getValidMoves());

        testModel.circlePosition=new Position(3,5);
        testValidMoves.clear();
        testValidMoves.add(PawnDirection.UP);
        testValidMoves.add(PawnDirection.DOWN);
        testValidMoves.add(PawnDirection.RIGHT);
        assertEquals(testValidMoves, testModel.getValidMoves());

        testModel.circlePosition=new Position(3,6);
        testValidMoves.clear();
        testValidMoves.add(PawnDirection.UP);
        testValidMoves.add(PawnDirection.LEFT);
        assertEquals(testValidMoves, testModel.getValidMoves());

        testModel.circlePosition=new Position(4,0);
        testValidMoves.clear();
        testValidMoves.add(PawnDirection.RIGHT);
        testValidMoves.add(PawnDirection.UP);
        assertEquals(testValidMoves, testModel.getValidMoves());

        testModel.circlePosition=new Position(4,3);
        testValidMoves.clear();
        testValidMoves.add(PawnDirection.RIGHT);
        testValidMoves.add(PawnDirection.DOWN);
        testValidMoves.add(PawnDirection.LEFT);
        assertEquals(testValidMoves, testModel.getValidMoves());

        testModel.circlePosition=new Position(4,4);
        testValidMoves.clear();
        testValidMoves.add(PawnDirection.RIGHT);
        testValidMoves.add(PawnDirection.UP);
        testValidMoves.add(PawnDirection.LEFT);
        assertEquals(testValidMoves, testModel.getValidMoves());

        testModel.circlePosition=new Position(4,6);
        testValidMoves.clear();
        testValidMoves.add(PawnDirection.DOWN);
        testValidMoves.add(PawnDirection.LEFT);
        assertEquals(testValidMoves, testModel.getValidMoves());

        testModel.circlePosition=new Position(5,0);
        testValidMoves.clear();
        testValidMoves.add(PawnDirection.DOWN);
        testValidMoves.add(PawnDirection.RIGHT);
        assertEquals(testValidMoves, testModel.getValidMoves());

        testModel.circlePosition=new Position(5,1);
        testValidMoves.clear();
        testValidMoves.add(PawnDirection.UP);
        testValidMoves.add(PawnDirection.LEFT);
        testValidMoves.add(PawnDirection.DOWN);
        assertEquals(testValidMoves, testModel.getValidMoves());

        testModel.circlePosition=new Position(5,3);
        testValidMoves.clear();
        testValidMoves.add(PawnDirection.UP);
        testValidMoves.add(PawnDirection.RIGHT);
        testValidMoves.add(PawnDirection.DOWN);
        assertEquals(testValidMoves, testModel.getValidMoves());

        testModel.circlePosition=new Position(5,4);
        testValidMoves.clear();
        testValidMoves.add(PawnDirection.RIGHT);
        testValidMoves.add(PawnDirection.LEFT);
        testValidMoves.add(PawnDirection.DOWN);
        assertEquals(testValidMoves, testModel.getValidMoves());

        testModel.circlePosition=new Position(6,2);
        testValidMoves.clear();
        testValidMoves.add(PawnDirection.RIGHT);
        testValidMoves.add(PawnDirection.LEFT);
        assertEquals(testValidMoves, testModel.getValidMoves());

        testModel.circlePosition=new Position(6,3);
        testValidMoves.clear();
        testValidMoves.add(PawnDirection.UP);
        testValidMoves.add(PawnDirection.LEFT);
        assertEquals(testValidMoves, testModel.getValidMoves());

        testModel.circlePosition=new Position(6,4);
        testValidMoves.clear();
        testValidMoves.add(PawnDirection.UP);
        testValidMoves.add(PawnDirection.RIGHT);
        assertEquals(testValidMoves, testModel.getValidMoves());

        testModel.circlePosition=new Position(6,5);
        testValidMoves.clear();
        testValidMoves.add(PawnDirection.UP);
        testValidMoves.add(PawnDirection.LEFT);
        assertEquals(testValidMoves, testModel.getValidMoves());

        testModel.circlePosition=new Position(6,6);
        testValidMoves.clear();
        testValidMoves.add(PawnDirection.UP);
        assertEquals(testValidMoves, testModel.getValidMoves());
    }

    @Test
    void testMove(){
        testModel.circlePosition=new Position(1,4);
        expected= new Position(1,0);
        testModel.move(PawnDirection.LEFT);
        assertEquals(expected ,testModel.circlePosition);

        testModel.circlePosition=new Position(0,0);
        expected= new Position(0,0);
        testModel.move(PawnDirection.LEFT);
        assertEquals(expected ,testModel.circlePosition);

        testModel.circlePosition=new Position(0,0);
        expected= new Position(0,0);
        testModel.move(PawnDirection.RIGHT);
        assertEquals(expected ,testModel.circlePosition);


    }

    @Test
    void testPositionToString(){
        testModel.circlePosition=new Position(1,4);
        String expected = "(1,4)";
        assertEquals(expected,testModel.circlePosition.toString());
    }


}
