package Controllers;

import Daos.chessDao;
import View.chessView;
import org.springframework.stereotype.Controller;

@Controller
public class controller {

    private chessView view;
    private chessDao dao;

    public controller(chessView view, chessDao dao){
        this.view = view;
        this.dao = dao;
    }

    public void run(){
        dao.init();
        boolean playing = true;
        while(playing){

        }
    }
}
