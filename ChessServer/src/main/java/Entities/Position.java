package Entities;

import Entities.Pieces.piece;

public class Position {

    private piece currentPiece;

    public Position(){
        setCurrentPiece(null);
    }

    public piece getCurrentPiece() {
        return currentPiece;
    }

    public void setCurrentPiece(piece currentPiece) {
        this.currentPiece = currentPiece;
    }
}
