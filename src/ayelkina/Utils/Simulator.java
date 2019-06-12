package ayelkina.Utils;

import ayelkina.Model.Element;
import ayelkina.Model.Position;
import ayelkina.Model.VoidElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static ayelkina.Utils.Constants.*;

public class Simulator {
    private List<Element> elements = new ArrayList<>();
    private AStar algorithm = new AStar();
    private VoidElement voidElement = new VoidElement();
    private Element[][] elementsMap = new Element[WIDTH][HEIGHT];

    public void start() {
        createElementList();
        setRandomPositions();
        startAlgorithm();
    }

    private void createElementList() {
        voidElement.setAimPosition(new Position(WIDTH, HEIGHT));

        elements.add(voidElement);
        int index = 1;

        for (int x = 0; x < WIDTH; ++x)
            for (int y = 0; y < HEIGHT; ++y) {
                Element element = new Element(index++);
                element.setAimPosition(new Position(x, y));

                elements.add(element);
            }
    }

    private void setRandomPositions() {
        Collections.shuffle(elements);

        int index = 0;
        for (int x = 0; x < WIDTH; ++x)
            for (int y = 0; y < HEIGHT; ++y) {
                Element currentElement = elements.get(index++);
                if(currentElement instanceof VoidElement) {
                    voidElement.setPosition(new Position(x, y));
                }
                else {
                    currentElement.setPosition(new Position(x, y));
                }
                elementsMap[x][y] = currentElement;
            }
    }

    private void startAlgorithm() {
        Position voidPosition = voidElement.getPosition();

        System.out.println();

    }


}
