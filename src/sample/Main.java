package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample2.fxml"));
//        Parent root2 = FXMLLoader.load(getClass().getResource("sample1.fxml"));
        primaryStage.setTitle("Karol Nowak 1");
        primaryStage.setScene(new Scene(root, 660, 440));
        primaryStage.show();

//        secondaryStage.setTitle("Karol Nowak 2");
//        secondaryStage.setScene(new Scene(root, 600, 400));

    }

    public static void main(String[] args) {
        launch(args);
    }

}
