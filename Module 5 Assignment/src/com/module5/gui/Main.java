package com.module5.gui;

import com.module5.db.DBHandler;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Initialize the database
        DBHandler.initialize();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/loginWindow.fxml"));
        Parent root = loader.load();
        stage.setTitle("Login");
        stage.setScene(new Scene(root, 720, 500));
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
