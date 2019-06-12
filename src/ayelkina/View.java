package ayelkina;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class View {
    private double BUTTONSIZE = 60;
    private GridPane gridPane = new GridPane();
    private Button goButton = new Button("Go");
    private Button emptyButton = new Button();
    private List<Button> buttonList = new ArrayList<>();


    View(Stage primaryStage) {
        primaryStage.setTitle("Puzzle");
        createButtons();
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();

        setGoButtonListener();
        setNumberButtonsListeners();
    }

    private void createButtons() {
        for (int i = 1; i < 16; ++i) {
            Button button = new Button(String.valueOf(i));
            button.setPrefSize(BUTTONSIZE, BUTTONSIZE);
            buttonList.add(button);
        }


        emptyButton.setPrefSize(BUTTONSIZE,BUTTONSIZE);
        emptyButton.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        buttonList.add(emptyButton);

        Collections.shuffle(buttonList);
    }

    private Parent createContent() {
        addButtons();
        return gridPane;
    }

    private void addButtons() {
        int index = 0;
        for(int i = 0; i < 4; ++i)
            for(int j = 0; j < 4; ++j) {
                int number = index++;

                gridPane.add(buttonList.get(number), j, i);
        }
        goButton.setPrefSize(BUTTONSIZE*4, BUTTONSIZE);
        gridPane.add(goButton, 0, 5, 4, 1);
    }

    private void setGoButtonListener() {
        goButton.setOnAction( event -> {
            System.out.println("Go-go-go");
        });
    }

    private void setNumberButtonsListeners() {
        for(Button button : buttonList) {
            if(button != emptyButton) {
                button.setOnAction(e -> {
                    moveButtonToEmptyPlace(button);
                });
            }
        }
    }

    private void moveButtonToEmptyPlace(Button button) {
        int numberButtonColumn = GridPane.getColumnIndex(button);
        int numberButtonRow = GridPane.getRowIndex(button);
        int emptyPlaceColumn = GridPane.getColumnIndex(emptyButton);
        int emptyPlaceRow = GridPane.getRowIndex(emptyButton);
        int difference;

        if(numberButtonRow == emptyPlaceRow) {
            difference = numberButtonColumn > emptyPlaceColumn ? numberButtonColumn - emptyPlaceColumn :
                    emptyPlaceColumn - numberButtonColumn;

            if(difference == 1) {
                swapButtons(button, numberButtonColumn, numberButtonRow, emptyPlaceColumn, emptyPlaceRow);
                return;
            }
        }

        if(numberButtonColumn == emptyPlaceColumn) {
            difference = numberButtonRow > emptyPlaceRow ? numberButtonRow - emptyPlaceRow :
                    emptyPlaceRow - numberButtonRow;

            if(difference == 1) {
                swapButtons(button, numberButtonColumn, numberButtonRow, emptyPlaceColumn, emptyPlaceRow);
            }
        }

    }

    private void swapButtons(Button button, int numberButtonColumn, int numberButtonRow, int emptyPlaceColumn, int emptyPlaceRow) {
        int tempCol, tempRow;
        tempCol = numberButtonColumn;
        tempRow = numberButtonRow;
        GridPane.setColumnIndex(button, emptyPlaceColumn);
        GridPane.setRowIndex(button, emptyPlaceRow);
        GridPane.setColumnIndex(emptyButton, tempCol);
        GridPane.setRowIndex(emptyButton, tempRow);
    }

}
