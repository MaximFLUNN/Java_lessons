import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloFX extends Application {

    @Override
    public void start(Stage stage) {try {
        //Parent window;
        //window = (StackPane)FXMLLoader.load(getClass().getResource("main.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(
                getClass().getResource("main.fxml"));
        Scene scene = null;

            scene = new Scene(fxmlLoader.load(), 600, 400);

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //String javaVersion = System.getProperty("java.version");
        //String javafxVersion = System.getProperty("javafx.version");
        //Label l = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        //Scene scene = new Scene(new StackPane(l), 640, 480);
        //stage.setScene(scene);
        //stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}

