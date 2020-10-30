package Entities.Pieces;

import Entities.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class bishop extends piece{

    public bishop(int color){
        super(color);
    }

    @Override
    public List<Integer> possibleMoves(int pos, Map<Integer, Position> board) {
        List<Integer> moves = new ArrayList<>();
        piece currentPiece = board.get(pos).getCurrentPiece();
        piece tmpPiece;
        int tempPos;
        if(pos%8 != 0 && pos < 56){
            if(pos < 56) {
                do {
                    tmpPiece = board.get(pos+7).getCurrentPiece();
                    if(tmpPiece == null) {
                        tempPos = pos + 7;
                        moves.add(tempPos);
                    }
                    else if(comparePos(currentPiece,tmpPiece) == 1){
                        tempPos = pos + 7;
                        moves.add(tempPos);
                        break;
                    }
                    else break;
                }
                while (tempPos < 56);
            }
            if(pos > 7){
                do{
                    tmpPiece = board.get(pos-9).getCurrentPiece();
                    if(tmpPiece == null) {
                        tempPos = pos - 9;
                        moves.add(tempPos);
                    }
                    else if(comparePos(currentPiece,tmpPiece) == 1){
                        tempPos = pos - 9;
                        moves.add(tempPos);
                        break;
                    }
                    else break;
                }
                while(tempPos>7);
            }
        }
        if(pos%8 != 7){
            if(pos < 56){
                do{
                    tmpPiece = board.get(pos+9).getCurrentPiece();
                    if(tmpPiece == null) {
                        tempPos = pos + 9;
                        moves.add(tempPos);
                    }
                    else if(comparePos(currentPiece,tmpPiece) == 1){
                        tempPos = pos + 9;
                        moves.add(tempPos);
                        break;
                    }
                    else break;
                }
                while(tempPos < 56);
            }
            if(pos > 7) {
                do {
                    tmpPiece = board.get(pos-7).getCurrentPiece();
                    if(tmpPiece == null) {
                        tempPos = pos - 7;
                        moves.add(tempPos);
                    }
                    else if(comparePos(currentPiece,tmpPiece) == 1){
                        tempPos = pos - 7;
                        moves.add(tempPos);
                        break;
                    }
                    else break;
                }
                while (tempPos > 7);
            }
        }


        return moves;
    }
}
