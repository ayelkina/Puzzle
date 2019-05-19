package ayelkina;

import javafx.stage.Stage;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        View view = new View(primaryStage);
    }

    public static void main(String[] args) {
        javafx.application.Application.launch(args);
    }
}
