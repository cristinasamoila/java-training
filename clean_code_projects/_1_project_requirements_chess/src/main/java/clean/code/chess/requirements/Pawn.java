package clean.code.chess.requirements;

import java.awt.*;

public class Pawn extends Piece {

    private final String Type = "Pawn";

    public Pawn(PieceColor color) {
        super(color);
    }

    @Override
    public String getType() {
        return Type;
    }

    @Override
    public void Move(MovementType movementType, Position newPosition) {
        if (ChessBoard.getInstance().IsLegalBoardPosition(newPosition) && isValidNewPosition(newPosition)) {
            ChessBoard.getInstance().mapOfPositionAndPiece.put(getPosition(), null);
            super.setPositionOnChessBoard(ChessBoard.getInstance(), newPosition);
            ChessBoard.getInstance().mapOfPositionAndPiece.put(newPosition, this);
        }
    }

    @Override
    public void Capture(MovementType movementType, int newX, int newY) {
        throw new UnsupportedOperationException("Need to implement Pawn.Capture()");
    }

    @Override
    public String toString() {
        return CurrentPositionAsString();
    }


    public boolean isValidNewPosition(Position newPosition) {
        if (getPieceColor().equals(Color.WHITE))
            return areMovingCoordinatesValid_WhiteCase(newPosition.getxCoordinate(), newPosition.getyCoordinate());
        return areMovingCoordinatesValid_BlackCase(newPosition.getxCoordinate(), newPosition.getyCoordinate());
    }


    public boolean areMovingCoordinatesValid_WhiteCase(int xCoordinate, int yCoordinate) {
        return yCoordinate == getPosition().getyCoordinate() &&
                xCoordinate == getPosition().getxCoordinate() + 1;
    }

    public boolean areMovingCoordinatesValid_BlackCase(int xCoordinate, int yCoordinate) {
        return yCoordinate == getPosition().getyCoordinate() &&
                xCoordinate == getPosition().getxCoordinate() - 1;

    }
}
