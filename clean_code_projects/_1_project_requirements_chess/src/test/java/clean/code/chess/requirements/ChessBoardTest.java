package clean.code.chess.requirements;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ChessBoardTest extends TestCase {

    private ChessBoard testSubject;

    @Before
    public void setUp() throws Exception {
        testSubject = ChessBoard.getInstance();
    }

    @Test
    public void testHas_MaxBoardWidth_of_7() {
        assertEquals(7, ChessBoard.MAX_BOARD_HEIGHT);
    }

    @Test
    public void testHas_MaxBoardHeight_of_7() {
        assertEquals(7, ChessBoard.MAX_BOARD_HEIGHT);
    }

    @Test
    public void testIsLegalBoardPosition_True_X_equals_0_Y_equals_0() {
        boolean isValidPosition = testSubject.IsLegalBoardPosition(new Position(0, 0));
        assertTrue(isValidPosition);
    }

    @Test
    public void testIsLegalBoardPosition_True_X_equals_5_Y_equals_5() {
        boolean isValidPosition = testSubject.IsLegalBoardPosition(new Position(5, 5));
        Assert.assertTrue(isValidPosition);
    }

    @Test
    public void testIsLegalBoardPosition_False_X_equals_11_Y_equals_5() {
        boolean isValidPosition = testSubject.IsLegalBoardPosition(new Position(11, 5));
        assertFalse(isValidPosition);
    }

    @Test
    public void testIsLegalBoardPosition_False_X_equals_0_Y_equals_9() {
        boolean isValidPosition = testSubject.IsLegalBoardPosition(new Position(0, 9));
        assertFalse(isValidPosition);
    }

    @Test
    public void testIsLegalBoardPosition_False_X_equals_11_Y_equals_0() {
        boolean isValidPosition = testSubject.IsLegalBoardPosition(new Position(11, 0));
        assertFalse(isValidPosition);
    }

    @Test
    public void testIsLegalBoardPosition_False_For_Negative_Y_Values() {
        boolean isValidPosition = testSubject.IsLegalBoardPosition(new Position(5, -1));
        Assert.assertFalse(isValidPosition);
    }

    @Test
    public void testAvoids_Duplicate_Positioning() {
        Piece firstPawn = new Pawn(PieceColor.BLACK);
        Piece secondPawn = new Pawn(PieceColor.BLACK);
        Position position = new Position(6, 3);
        testSubject.Add(firstPawn, position);
        testSubject.Add(secondPawn, position);
        assertEquals(6, firstPawn.getPosition().getxCoordinate());
        assertEquals(3, firstPawn.getPosition().getyCoordinate());
        assertEquals(-1, secondPawn.getPosition().getxCoordinate());
        assertEquals(-1, secondPawn.getPosition().getyCoordinate());
    }

    @Test
    public void testLimits_The_Number_Of_Pawns() {
        for (int i = 0; i < 10; i++) {
            Pawn pawn = new Pawn(PieceColor.BLACK);
            int row = i / ChessBoard.MAX_BOARD_WIDTH;
            Position position = new Position(6 + row, i % ChessBoard.MAX_BOARD_WIDTH);
            testSubject.Add(pawn, position);
            if (row < 1) {
                assertEquals(6 + row, pawn.getPosition().getxCoordinate());
                assertEquals(i % ChessBoard.MAX_BOARD_WIDTH, pawn.getPosition().getyCoordinate());
            } else {
                assertEquals(-1, pawn.getPosition().getxCoordinate());
                Assert.assertEquals(-1, pawn.getPosition().getyCoordinate());
            }
        }
    }

    @Test
    public void testMoveAPawnFromAPosition_and_AddAnotherPawnOnIt() {
        Piece firstPawn = new Pawn(PieceColor.BLACK);
        Position position = new Position(6, 3);
        testSubject.Add(firstPawn, position);

        Position newPosition = new Position(5, 3);
        firstPawn.Move(MovementType.MOVE, newPosition);

        Piece secondPawn = new Pawn(PieceColor.BLACK);
        testSubject.Add(secondPawn, position);

        assertEquals(5, firstPawn.getPosition().getxCoordinate());
        assertEquals(3, firstPawn.getPosition().getyCoordinate());
        assertEquals(6, secondPawn.getPosition().getxCoordinate());
        assertEquals(3, secondPawn.getPosition().getyCoordinate());

    }
}