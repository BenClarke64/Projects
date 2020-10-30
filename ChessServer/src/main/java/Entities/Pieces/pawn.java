package Entities.Pieces;

import Entities.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class pawn extends piece{

    private int color;

    public pawn(int color){
        super(color);
    }

    @Override
    public List<Integer> possibleMoves(int pos, Map<Integer, Position> board){
        piece tmpPiece;
        List<Integer> moves = new ArrayList<>();
        if(color == 0) {
            if(board.get(pos+8).getCurrentPiece() == null) {
                moves.add(pos + 8);
                if (pos > 7 && pos < 16 && board.get(pos+16).getCurrentPiece() == null) {
                    moves.add(pos + 16);
                }
            }
            tmpPiece =  board.get(pos+7).getCurrentPiece();
            if(pos%8 != 0 && tmpPiece != null){
                if(tmpPiece.getColor() != board.get(pos).getCurrentPiece().getColor()) {
                    moves.add(pos + 7);
                }
            }
            tmpPiece = board.get(pos+9).getCurrentPiece();
            if(pos%8 != 7 && tmpPiece != null){
                if(tmpPiece.getColor() != board.get(pos).getCurrentPiece().getColor()) {
                    moves.add(pos + 9);
                }
            }
        }
        else{
            if(board.get(pos-8).getCurrentPiece() == null) {
                moves.add(pos - 8);
                if (pos > 7 && pos < 16 && board.get(pos-16).getCurrentPiece() == null) {
                    moves.add(pos - 16);
                }
            }
            tmpPiece =  board.get(pos-7).getCurrentPiece();
            if(pos%8 != 0 && tmpPiece != null){
                if(tmpPiece.getColor() != board.get(pos).getCurrentPiece().getColor()) {
                    moves.add(pos - 7);
                }
            }
            tmpPiece = board.get(pos-9).getCurrentPiece();
            if(pos%8 != 7 && tmpPiece != null){
                if(tmpPiece.getColor() != board.get(pos).getCurrentPiece().getColor()) {
                    moves.add(pos - 9);
                }
            }
        }
        return moves;
    }
}
