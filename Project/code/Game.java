package sample;

import javafx.stage.Stage;
import java.io.*;

public class Game implements Serializable {
    private Game game;                          //to store itself if serialization done from here
    private int highScore;
    private Player player;
    private Objects <GameObject> gameObjects;
    private FileOutputStream fileOut;                   //the file writer to write to the file that we will serialise to
    private ObjectOutputStream out;                     //the object writer that will write to the file using the file writer
    private FileInputStream fileIn;                     //the file reader to read from the file that we will serialise to
    private ObjectInputStream in;                       //the object reader that will read from the file using the file reader
    private Home home;
    private Stage stage;

    public Game(Stage s){
        this.game = this;            //to serialise itself from a method within
        this.home = new Home(this);
        this.stage = s;
        this.highScore = 0;
        try{
            fileOut = new FileOutputStream("Serialise.txt");
            out = new ObjectOutputStream(fileOut);
        }
        catch(Exception e){
            System.out.println(e);
        }
        try{
            fileIn = new FileInputStream("Serialise.txt");
            in = new ObjectInputStream(fileIn);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public int getHighScore(){
        return this.highScore;
    }

    public void startGame() throws Exception{
        home.start(stage);
    }
}