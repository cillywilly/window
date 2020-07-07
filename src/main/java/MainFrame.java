import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.InputStream;

public class MainFrame extends Application {

    public static void main(String[] args){
        Application.launch();
    }
    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("/MyScene.fxml"));

        primaryStage.setTitle("MyFirstWindow");

        InputStream iconStream =
                getClass().getResourceAsStream("/Photo.png");
        Image image = new Image(iconStream);
        primaryStage.getIcons().add(image);

        primaryStage.setScene(new Scene(root));

        primaryStage.show();
    }

}
