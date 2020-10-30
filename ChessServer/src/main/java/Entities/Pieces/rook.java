package Entities.Pieces;

import Entities.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class rook extends piece{

    public rook(int color){
        super(color);
    }

    @Override
    public List<Integer> possibleMoves(int pos, Map<Integer, Position> board) {
        List<Integer> moves = new ArrayList<>();
        piece currentPiece = board.get(pos).getCurrentPiece();
        piece tmpPiece;
        int tempPos;
        if(pos%8!=7){
            do {
                tmpPiece = board.get(pos++).getCurrentPiece();
                if(tmpPiece == null) {
                    tempPos = pos ++;
                    moves.add(tempPos);
                }
                else if(comparePos(currentPiece,tmpPiece) == 1){
                    tempPos = pos ++;
                    moves.add(tempPos);
                    break;
                }
                else break;
            }
            while(pos%8!=7);
        }
        if(pos%8!=0){
            do {
                tmpPiece = board.get(pos--).getCurrentPiece();
                if(tmpPiece == null) {
                    tempPos = pos --;
                    moves.add(tempPos);
                }
                else if(comparePos(currentPiece,tmpPiece) == 1){
                    tempPos = pos --;
                    moves.add(tempPos);
                    break;
                }
                else break;
            }
            while (pos%8!=0);
        }
        if(pos>7){
            do{
                tmpPiece = board.get(pos-=8).getCurrentPiece();
                if(tmpPiece == null) {
                    tempPos = pos -=8;
                    moves.add(tempPos);
                }
                else if(comparePos(currentPiece,tmpPiece) == 1){
                    tempPos = pos -=8;
                    moves.add(tempPos);
                    break;
                }
                else break;
            }
            while(tempPos>7);
        }
        if(pos < 56){
            do{
                tmpPiece = board.get(pos+=8).getCurrentPiece();
                if(tmpPiece == null) {
                    tempPos = pos +=8;
                    moves.add(tempPos);
                }
                else if(comparePos(currentPiece,tmpPiece) == 1){
                    tempPos = pos +=8;
                    moves.add(tempPos);
                    break;
                }
                else break;
            }
            while(tempPos < 56);
        }
        return moves;
    }

    public double getType(){
        return 5.1;
    }
}
