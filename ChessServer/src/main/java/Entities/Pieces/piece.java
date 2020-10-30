package Entities.Pieces;

import Entities.Position;

import java.util.List;
import java.util.Map;

public class piece {

    private int color;

    public piece(int color){
        this.color = color;
    }

    public int getColor() {
        return color;
    }

    public List<Integer> possibleMoves(int pos, Map<Integer, Position> board){
        return null;
    }

    public int comparePos(piece pos, piece move){
        if(move == null){
            return 0;
        }
        if(move.getColor() != pos.getColor()){
            return 1;
        }
        else return 2;
    }

    public double getType(){
        return 0;
    }
}
