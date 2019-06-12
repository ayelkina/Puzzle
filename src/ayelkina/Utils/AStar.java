package ayelkina.Utils;


import ayelkina.Model.Element;
import ayelkina.Model.Position;

import java.util.ArrayList;
import java.util.List;

import static ayelkina.Utils.Constants.HEIGHT;
import static ayelkina.Utils.Constants.WIDTH;

public class AStar {

    public AStar() {
//        setAimPositions();
    }

 /*   private void setAimPositions() {
        for(int x = 0; x < WIDTH; ++x)
            for(int y = 0; y < HEIGHT; ++y) {
                aimPositionList.add(new Position(x, y));
            }
    }*/

    int findHeuristicForElement(Element element) {
        return element.getPosition().distance(element.getAimPosition());
    }
}
