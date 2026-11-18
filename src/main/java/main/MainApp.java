package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import db.Database;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Database.prepareDatabase();
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/view/katalog.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 1000, 760);
        stage.setTitle("Katalog Produk UPI Store");
        stage.setMinWidth(680);
        stage.setMinHeight(500);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
