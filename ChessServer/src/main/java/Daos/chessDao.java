package Daos;

import Entities.Pieces.*;
import Entities.Position;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class chessDao {
    Map<Integer, Position> board;
    private int whoseTurn;
    private int currentPos;
    private List<piece> whiteLostPieces, blackLostPieces;


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

    public List<Integer> pieceClickedOn(int pos){
        currentPos = pos;
        return board.get(pos).getCurrentPiece().possibleMoves(pos,board);
    }

    public void movePiece(int pos){
        Position tmpPiece = board.get(currentPos);
        if(checkPosition(pos)){
            if(whoseTurn == 0){//add the taken piece to the oppositions taken piece pile
                blackLostPieces.add(tmpPiece.getCurrentPiece());
            }
            else whiteLostPieces.add(tmpPiece.getCurrentPiece());
        }
        board.put(currentPos, new Position());
        board.put(pos, tmpPiece);
    }

    public List<piece> getTakenPieces(int who){
        if(who == 0){
            return whiteLostPieces;
        }
        else{
            return blackLostPieces;
        }
    }

    public Map<Integer,Position> getBoard(){
        return board;
    }

    public void changeTurn(){
        if(whoseTurn == 0){
            whoseTurn = 1;
        }
        else whoseTurn = 0;
    }
}
