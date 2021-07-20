package clean.code.chess.requirements;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PawnTest {

    private ChessBoard chessBoard;
    private Pawn testSubject;

    @Before
    public void setUp() {
        this.chessBoard = ChessBoard.getInstance();
        this.testSubject = new Pawn(PieceColor.BLACK);
    }

    @Test
    public void testChessBoard_Add_Sets_XCoordinate() {
        this.chessBoard.Add(testSubject, new Position(6, 3));
        assertEquals(6, testSubject.getPosition().getxCoordinate());
    }

    @Test
    public void testChessBoard_Add_Sets_YCoordinate() {
        this.chessBoard.Add(testSubject, new Position(6, 3));
        assertEquals(3, testSubject.getPosition().getyCoordinate());

    }


    @Test
    public void testPawn_Move_IllegalCoordinates_Right_DoesNotMove() {
        chessBoard.Add(testSubject, new Position(6, 3));
        Position newPosition = new Position(7, 3);
        testSubject.Move(MovementType.MOVE, newPosition);
        assertEquals(6, testSubject.getPosition().getxCoordinate());
        assertEquals(3, testSubject.getPosition().getyCoordinate());
    }

    @Test
    public void testPawn_Move_IllegalCoordinates_Left_DoesNotMove() {
        chessBoard.Add(testSubject, new Position(6, 3));
        Position newPosition = new Position(4, 3);
        testSubject.Move(MovementType.MOVE, newPosition);
        assertEquals(6, testSubject.getPosition().getxCoordinate());
        assertEquals(3, testSubject.getPosition().getyCoordinate());
    }

    @Test
    public void testPawn_Move_LegalCoordinates_Forward_UpdatesCoordinates() {
        chessBoard.Add(testSubject, new Position(6, 3));
        Position newPosition = new Position(5, 3);
        testSubject.Move(MovementType.MOVE, newPosition);
        assertEquals(5, testSubject.getPosition().getxCoordinate());
        assertEquals(3, testSubject.getPosition().getyCoordinate());
    }


}