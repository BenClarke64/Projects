package Daos;

import Entities.Position;

import java.util.Map;

public class dao {
    Map<Integer, Position> board;


    public void init(){
        for(int i = 0; i < 64;i++){
            board.put(i,new Position());
        }
    }
}
