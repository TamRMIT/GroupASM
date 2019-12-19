package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

class Shape
{
    ImageView image;
    boolean occupied;

    Shape(ImageView image, boolean occupied)
    {
        this.image = image;
        this.occupied = occupied;
    }
}

class ChessBoard extends Pane
{
    GridPane gridPane = new GridPane();
    Shape[] shape = new Shape[96];

    private void createBoard()
    {
        // Create circles
        for (int i = 0; i < 56; i++)
        {
            shape[i] = new Shape(new ImageView("file:src/image/circle.png"), false);
            shape[i].image.setFitWidth(50);
            shape[i].image.setPreserveRatio(true);
            shape[i].image.setSmooth(true);

            if (i <= 6) { gridPane.add(shape[i].image, 6, i);  }
            else if (i <= 12) { gridPane.add(shape[i].image, 12 - i, 6); }
            else if (i == 13) { gridPane.add(shape[i].image, 0, 7); }
            else if (i <= 19) { gridPane.add(shape[i].image, i - 14, 8); }
            else if (i <= 26) { gridPane.add(shape[i].image, 6, i - 12); }
            else if (i == 27) { gridPane.add(shape[i].image, 7, 14); }
            else if (i <= 34) { gridPane.add(shape[i].image, 8, 42 - i); }
            else if (i <= 40) { gridPane.add(shape[i].image, i - 26, 8); }
            else if (i == 41) { gridPane.add(shape[i].image, 14, 7); }
            else if (i <= 47) { gridPane.add(shape[i].image, 56 - i, 6); }
            else if (i <= 54) { gridPane.add(shape[i].image, 8, 54 - i); }
            else { gridPane.add(shape[i].image, 7, 0); }
        }
        // Create pieces
        for (int i = 56; i < 72; i++)
        {
            if (i <= 59) {
                shape[i] = new Shape(new ImageView("file:src/image/red.png"), true);
                shape[i].image.setFitWidth(50);
                shape[i].image.setPreserveRatio(true);
                shape[i].image.setSmooth(true);
                gridPane.add(shape[i].image, 0, i - 56);
            }
            else if (i <= 63) {
                shape[i] = new Shape(new ImageView("file:src/image/green.png"), true);
                shape[i].image.setFitWidth(50);
                shape[i].image.setPreserveRatio(true);
                shape[i].image.setSmooth(true);
                gridPane.add(shape[i].image, 0, 74 - i);
            }
            else if (i <= 67) {
                shape[i] = new Shape(new ImageView("file:src/image/yellow.png"), true);
                shape[i].image.setFitWidth(50);
                shape[i].image.setPreserveRatio(true);
                shape[i].image.setSmooth(true);
                gridPane.add(shape[i].image, 14, 78 - i);
            }
            else {
                shape[i] = new Shape(new ImageView("file:src/image/blue.png"), true);
                shape[i].image.setFitWidth(50);
                shape[i].image.setPreserveRatio(true);
                shape[i].image.setSmooth(true);
                gridPane.add(shape[i].image, 14, i - 68);
            }
        }
        // Create rectangles
        for (int i = 72; i < 96; i++)
        {
            shape[i] = new Shape(new ImageView("file:src/image/rectangle.png"), false);
            shape[i].image.setFitWidth(50);
            shape[i].image.setPreserveRatio(true);
            shape[i].image.setSmooth(true);
            if (i <= 77) {gridPane.add(shape[i].image, 7, i - 71); }
            else if (i <= 83) {shape[i].image.setRotate(90); gridPane.add(shape[i].image, i - 77, 7); }
            else if (i <= 89) {gridPane.add(shape[i].image, 7, 97 - i); }
            else {shape[i].image.setRotate(90); gridPane.add(shape[i].image, 103 - i, 7); }
        }
    }

    ChessBoard()
    {
        createBoard();
        getChildren().add(gridPane);
    }
}

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        ChessBoard chessBoard = new ChessBoard();
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(chessBoard);
        primaryStage.setTitle("Chess");
        primaryStage.setScene(new Scene(borderPane, 800, 800));
        primaryStage.show();
    }
}
