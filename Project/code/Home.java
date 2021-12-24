package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Home extends Application {
    Game game;

    public Home(Game g){
        this.game = g;
    }

    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
        stage.setTitle("Will Hero");
        Image icon = new Image("/assets/logo.png");
        Scene scene = new Scene(root);
        stage.setResizable(false);
        scene.getStylesheets().add(getClass().getResource("StyleSheet.css").toExternalForm());
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.show();
    }
}
