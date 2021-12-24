package sample;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class Controller implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private Stage pauseStage;
    private Parent pauseRoot;
    private Scene pauseScene;

    @FXML
    private ImageView queen;
    @FXML
    private ImageView normalOrc;
    @FXML
    private ImageView mediumOrc;
    @FXML
    private ImageView bossOrc;
    @FXML
    private ImageView island1;

    @FXML
    Group heroAndWeapon;
    @FXML
    Group coinBunch1;
    @FXML
    Group coinBunch2;

    @FXML
    private Button resumeButton;
    @FXML
    private Button saveButton;
    @FXML
    private Button quitButton;
    @FXML
    private Button highScoreButton;
    @FXML
    private Button pauseButton;

    @FXML
    Label highScoreHome;

    @FXML
    public void pause(ActionEvent event) throws IOException {
        pauseStage = new Stage();
        pauseRoot = FXMLLoader.load(getClass().getResource("Scene3.fxml"));
        pauseScene = new Scene(pauseRoot);
        pauseScene.getStylesheets().add(getClass().getResource("StyleSheet.css").toExternalForm());
        Image icon = new Image("/assets/logo.png");
        pauseStage.getIcons().add(icon);
        pauseStage.setScene(pauseScene);
        pauseStage.initStyle(StageStyle.UNDECORATED);
        pauseStage.setResizable(false);
        pauseStage.initModality(Modality.APPLICATION_MODAL);
        pauseStage.initOwner(pauseButton.getScene().getWindow());
        pauseStage.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //translate/bounce
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(heroImage);
        translate.setCycleCount(TranslateTransition.INDEFINITE);
        translate.setDuration(Duration.millis(500));
        translate.setByY(-100);
        translate.setAutoReverse(true);
        translate.play();

        TranslateTransition translate10 = new TranslateTransition();
        translate10.setNode(island1);
        translate10.setCycleCount(TranslateTransition.INDEFINITE);
        translate10.setDuration(Duration.millis(10000));
        translate10.setByX(-500);
        //translate10.setAutoReverse(true);
        translate10.play();

        TranslateTransition translate11 = new TranslateTransition();
        translate11.setNode(island1);
        translate11.setCycleCount(TranslateTransition.INDEFINITE);
        translate11.setDuration(Duration.millis(500));
        translate11.setByY(-5);
        translate11.setAutoReverse(true);
        translate11.play();

        TranslateTransition translate2 = new TranslateTransition();
        translate2.setNode(normalOrc);
        translate2.setCycleCount(TranslateTransition.INDEFINITE);
        translate2.setDuration(Duration.millis(637));
        translate2.setByY(-60);
        translate2.setAutoReverse(true);
        translate2.play();

        TranslateTransition translate3 = new TranslateTransition();
        translate3.setNode(heroAndWeapon);
        translate3.setCycleCount(TranslateTransition.INDEFINITE);
        translate3.setDuration(Duration.millis(500));
        translate3.setByY(-100);
        translate3.setAutoReverse(true);
        translate3.play();

        TranslateTransition translate4 = new TranslateTransition();
        translate4.setNode(mediumOrc);
        translate4.setCycleCount(TranslateTransition.INDEFINITE);
        translate4.setDuration(Duration.millis(550));
        translate4.setByY(-65);
        translate4.setAutoReverse(true);
        translate4.play();

        TranslateTransition translate5 = new TranslateTransition();
        translate5.setNode(bossOrc);
        translate5.setCycleCount(TranslateTransition.INDEFINITE);
        translate5.setDuration(Duration.millis(637));
        translate5.setByY(-40);
        translate5.setAutoReverse(true);
        translate5.play();

        TranslateTransition translate6 = new TranslateTransition();
        translate6.setNode(coinBunch1);
        translate6.setCycleCount(TranslateTransition.INDEFINITE);
        translate6.setDuration(Duration.millis(842));
        translate6.setByY(-4);
        translate6.setAutoReverse(true);
        translate6.play();

        TranslateTransition translate7 = new TranslateTransition();
        translate7.setNode(coinBunch2);
        translate7.setCycleCount(TranslateTransition.INDEFINITE);
        translate7.setDuration(Duration.millis(1000));
        translate7.setByY(-2);
        translate7.setAutoReverse(true);
        translate7.play();
    }

    public void resume(ActionEvent event){
        resumeButton.getScene().getWindow().hide();
    }

    public void save(ActionEvent event){
        System.out.println("Game Saved");
        saveButton.getScene().getWindow().hide();
    }

    public void exit(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("You are about to exit");
        alert.setContentText("You may lose the progress if you haven't saved the game\nDo you wish to exit?");

        if(alert.showAndWait().get() == ButtonType.OK) {
            stage.close();
        }
    }
    public void goToStart(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
        scene = new Scene(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void highScoreView(ActionEvent event) throws IOException {
        try{
            root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
            scene = new Scene(root);
            highScoreHome.setText("HIGH SCORE: ");
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
            TimeUnit.SECONDS.sleep(4);
        }
        catch (Exception e){
            System.out.println("Sorry, some error occurred");
        }
        highScoreHome.setText("");
        root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
        scene = new Scene(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void playScene2(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("Scene4.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("StyleSheet.css").toExternalForm());
        stage.setOnCloseRequest(e -> {
            e.consume();
            exit(new ActionEvent());
        });
        stage.setScene(scene);
        stage.show();
    }

    public void playScene3(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("Scene5.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("StyleSheet.css").toExternalForm());
        stage.setOnCloseRequest(e -> {
            e.consume();
            exit(new ActionEvent());
        });
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScene2(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("StyleSheet.css").toExternalForm());
        stage.setOnCloseRequest(e -> {
            e.consume();
            exit(new ActionEvent());
        });
        stage.setScene(scene);
        stage.show();
    }
}