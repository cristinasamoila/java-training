package clean.code.chess.requirements;

public class Piece {

    private ChessBoard chessBoard;
    private Position position;
    private PieceColor color;

    public Piece(PieceColor color) {
        this.color = color;
    }

    public ChessBoard getChesssBoard() {
        return chessBoard;
    }

    public void setChessBoard(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setPositionOnChessBoard(ChessBoard chessBoard, Position position) {
        this.chessBoard = chessBoard;
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public PieceColor getPieceColor() {
        return this.color;
    }

    private void setPieceColor(PieceColor value) {
        color = value;
    }


    protected String CurrentPositionAsString() {
        String eol = System.lineSeparator();
        return String.format("Current X: {1}{0}Current Y: {2}{0}Piece Color: {3}", eol, position.getxCoordinate(), position.getyCoordinate(), color);
    }

    public String getType() {
        return "-";
    }

    public void Move(MovementType movementType, Position newPosition) {
        throw new UnsupportedOperationException("Default move method.");
    }

    public void Capture(MovementType movementType, int newX, int newY) {
        throw new UnsupportedOperationException("Default capture method.");
    }
}
