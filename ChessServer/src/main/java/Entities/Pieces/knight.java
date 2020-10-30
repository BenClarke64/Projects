package Entities.Pieces;

import Entities.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class knight extends piece{

    public knight(int color){
        super(color);
    }

    @Override
    public List<Integer> possibleMoves(int pos, Map<Integer, Position> board){
        List<Integer> moves = new ArrayList<>();
        if(pos%8 > 1){
            if(pos<56) {
                if(comparePos(board.get(pos).getCurrentPiece(),board.get(pos+6).getCurrentPiece()) < 2) {
                    moves.add(pos + 6);
                }
            }
            if(pos>7) {
                if (comparePos(board.get(pos).getCurrentPiece(), board.get(pos - 10).getCurrentPiece()) < 2) {
                    moves.add(pos - 10);
                }
            }
        }
        if(pos>15){
            if(pos%8!=0){
                if (comparePos(board.get(pos).getCurrentPiece(), board.get(pos - 17).getCurrentPiece()) < 2) {
                    moves.add(pos - 17);
                }
            }
            if(pos%8!=7){
                if (comparePos(board.get(pos).getCurrentPiece(), board.get(pos - 15).getCurrentPiece()) < 2) {
                    moves.add(pos - 15);
                }
            }
        }
        if(pos%8 < 6){
            if(pos>7){
                if (comparePos(board.get(pos).getCurrentPiece(), board.get(pos - 6).getCurrentPiece()) < 2) {
                    moves.add(pos - 6);
                }
            }
            if(pos<56){
                if (comparePos(board.get(pos).getCurrentPiece(), board.get(pos + 10).getCurrentPiece()) < 2) {
                    moves.add(pos + 10);
                }
            }
        }
        if(pos < 48){
            if(pos%8!=0){
                if (comparePos(board.get(pos).getCurrentPiece(), board.get(pos + 15).getCurrentPiece()) < 2) {
                    moves.add(pos + 15);
                }
            }
            if(pos%8!=7){
                if (comparePos(board.get(pos).getCurrentPiece(), board.get(pos + 17).getCurrentPiece()) < 2) {
                    moves.add(pos + 17);
                }
            }
        }
        return moves;
    }

    public double getType(){
        return 3.2;
    }

}
