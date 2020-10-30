package Entities.Pieces;

import Entities.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class king extends piece{

    public king(int color){
        super(color);
    }

    @Override
    public List<Integer> possibleMoves(int pos, Map<Integer, Position> board) {
        List<Integer> moves = new ArrayList<>();
        piece position = board.get(pos).getCurrentPiece();
        if(pos%8!=0){
            if(comparePos(position,board.get(pos--).getCurrentPiece())<2) {
                moves.add(pos--);
            }
            if(pos>7 && comparePos(position,board.get(pos-9).getCurrentPiece())<2){
                moves.add(pos-9);
            }
            if(pos<56 && comparePos(position,board.get(pos+7).getCurrentPiece())<2){
                moves.add(pos+7);
            }
        }
        if(pos>7 && comparePos(position,board.get(pos-8).getCurrentPiece())<2){
            moves.add(pos-8);
        }
        if(pos<56 && comparePos(position,board.get(pos+8).getCurrentPiece())<2){
            moves.add(pos+8);
        }
        if(pos%8!=7){
            if(comparePos(position,board.get(pos++).getCurrentPiece())<2) {
                moves.add(pos++);
            }
            if(pos>7 && comparePos(position,board.get(pos-7).getCurrentPiece())<2){
                moves.add(pos-7);
            }
            if(pos<56 && comparePos(position,board.get(pos+9).getCurrentPiece())<2){
                moves.add(pos+9);
            }
        }
        return moves;
    }

    public double getType(){
        return 20;
    }

}
