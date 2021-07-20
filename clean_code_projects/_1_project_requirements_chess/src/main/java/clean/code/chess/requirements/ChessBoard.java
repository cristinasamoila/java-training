package clean.code.chess.requirements;

import java.util.*;

public class ChessBoard {

    private static ChessBoard instance;
    public static int MAX_BOARD_WIDTH = 7;
    public static int MAX_BOARD_HEIGHT = 7;


    protected Map<Position, Piece> mapOfPositionAndPiece;

    private ChessBoard() {
        this.mapOfPositionAndPiece = new HashMap<>(MAX_BOARD_WIDTH * MAX_BOARD_HEIGHT);
    }

    public static ChessBoard getInstance() {
        if (instance == null)
            instance = new ChessBoard();
        return instance;
    }

    public Piece getPiece(Position position) {
        return mapOfPositionAndPiece.get(position);
    }


    public void Add(Piece piece, Position newPosition) {

        if (this.IsLegalBoardPosition(newPosition) && newPosition.isXCoordinateValid(piece)) {
            piece.setPositionOnChessBoard(this, newPosition);
            mapOfPositionAndPiece.put(newPosition, piece);
        } else {
            Position invalidPosition = new Position(-1, -1);
            piece.setPosition(invalidPosition);

        }
    }

    public boolean IsLegalBoardPosition(Position position) {
        return (position.isOnChessboard() && position.isFree());
    }

}
