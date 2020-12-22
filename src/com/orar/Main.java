package com.orar;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main  extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("autentificare/autentificare.fxml"));
        stage.setTitle("Orar inteligent");
        stage.setScene(new Scene(root, Ecran.WIDTH, Ecran.HEIGHT));
        stage.show();
    }
}
class Ecran{
    public static int WIDTH = 1090, HEIGHT = 453;
}