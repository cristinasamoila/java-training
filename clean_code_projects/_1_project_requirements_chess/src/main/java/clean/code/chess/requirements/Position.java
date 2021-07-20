package clean.code.chess.requirements;

public class Position {
    private final int xCoordinate;
    private final int yCoordinate;

    public Position(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public boolean isXCoordinateValid(Piece piece) {
        if (piece.getPieceColor() == PieceColor.BLACK) {
            if (piece.getType().equals("Pawn")) return (xCoordinate == 6);
            else return xCoordinate == 7;
        } else if (piece.getType().equals("Pawn"))
            return (xCoordinate == 1);
        return xCoordinate == 0;
    }

    public boolean isOnChessboard() {
        return ((0 <= xCoordinate && xCoordinate <= ChessBoard.MAX_BOARD_HEIGHT) &&
                (0 <= yCoordinate && yCoordinate <= ChessBoard.MAX_BOARD_WIDTH));
    }

    public boolean isFree() {
        return ChessBoard.getInstance().getPiece(this) == null;
    }


}
