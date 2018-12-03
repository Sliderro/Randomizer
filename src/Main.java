import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("Randomizer v2");
        Controller controller=new Controller();

        primaryStage.setScene(new Scene(controller.root()));
        primaryStage.show();
    }

    public static void main(String args[]){launch(args);}
}
