package ayelkina;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class View {
    private double WIDTH = 960;
    private double HEIGHT = 540;
    private double BUTTONSIZE = 60;
    private List<Button> buttonList = new ArrayList<>();
    private Button goButton = new Button("Go");
    private GridPane gridPane = new GridPane();

    View(Stage primaryStage) {
        primaryStage.setTitle("Puzzle");
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();
    }

    private Parent createContent() {

        createButtons();
        int index = 0;
        for(int i = 0; i < 4; ++i)
            for(int j = 0; j < 4; ++j) {
                gridPane.add(buttonList.get(index++), j, i);
        }
        goButton.setPrefSize(BUTTONSIZE*4, BUTTONSIZE);
        gridPane.add(goButton, 0, 5, 4, 1);
        return gridPane;
    }

    private void createButtons() {
        for (int i = 1; i < 16; ++i) {
            Button button = new Button(String.valueOf(i));
            button.setPrefSize(BUTTONSIZE, BUTTONSIZE);
            buttonList.add(button);
        }

        Button emptyButton = new Button();
        emptyButton.setPrefSize(BUTTONSIZE,BUTTONSIZE);
        emptyButton.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        buttonList.add(emptyButton);

        Collections.shuffle(buttonList);
    }
}
