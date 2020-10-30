package Daos;

import Entities.Pieces.*;
import Entities.Position;

import java.util.Map;

public class dao {
    Map<Integer, Position> board;
    private int whoseTurn;


    public void init(){
        whoseTurn = 0;
        Position pos = null;
        pos = new Position();
        pos.setCurrentPiece(new rook(0));
        board.put(0,pos);
        board.put(7,pos);

        pos.setCurrentPiece(new knight(0));
        board.put(1,pos);
        board.put(6,pos);

        pos.setCurrentPiece(new bishop(0));
        board.put(2,pos);
        board.put(5,pos);

        pos.setCurrentPiece(new queen(0));
        board.put(3,pos);

        pos.setCurrentPiece(new king(0));
        board.put(4,pos);

        for(int i = 8; i < 16;i++){
            pos = new Position();
            pos.setCurrentPiece(new pawn(0));
            board.put(i,pos);
        }

        for(int i = 16;i < 48;i++){
            board.put(i,new Position());
        }

        for(int i = 48;i < 56;i++){
            pos = new Position();
            pos.setCurrentPiece(new pawn(1));
            board.put(i,pos);
        }

        pos.setCurrentPiece(new rook(1));
        board.put(56,pos);
        board.put(63,pos);

        pos.setCurrentPiece(new knight(1));
        board.put(57,pos);
        board.put(62,pos);

        pos.setCurrentPiece(new bishop(1));
        board.put(58,pos);
        board.put(61,pos);

        pos.setCurrentPiece(new queen(1));
        board.put(59,pos);

        pos.setCurrentPiece(new king(1));
        board.put(60,pos);
    }
    
    private boolean checkPosition(int pos){
        Position check = board.get(pos);
        if(check.getCurrentPiece() == null){
            return false;
        }
        else if(check.getCurrentPiece().getColor() != whoseTurn){
            return true;
        }
        return false;
    }
}
