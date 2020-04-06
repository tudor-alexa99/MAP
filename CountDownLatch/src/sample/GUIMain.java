package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class GUIMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader =  new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();
        Start_Window_Controller controller = loader.getController();
        controller.setStartWindow(primaryStage);
        Scene primaryScene = new Scene(root, 800, 600);
        primaryStage.setScene(primaryScene);
        primaryStage.setTitle("ToyLanguage");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }


}
