package life.jacky.demo;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("View.fxml"));
        Scene scene = new Scene(root, Color.RED);
        scene.getStylesheets().add(getClass().getResource("Global.css").toExternalForm());

        Image icon = new Image("icon.jpg");
        stage.getIcons().add(icon);
        stage.setTitle("JavaFX Test");
        stage.setScene(scene);
        stage.show();
    }
//    void setupAutoSave() throws IOException {
//        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.5), e -> {
//            // Get Scene Loader
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("View.fxml"));
//            try {
//                loader.load();
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//            // Get Controller
//            ViewController viewController =  loader.getController();
//            try {
//                if (viewController.autoSaveCheckBox.isSelected()) {
//                    System.out.println("Autosave is on");
//                    viewController.saveData();
//                }
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        }));
//        timeline.setCycleCount(Animation.INDEFINITE);
//        timeline.playFromStart();
//    }
    public static void main(String[] args) {
        launch();
    }
}