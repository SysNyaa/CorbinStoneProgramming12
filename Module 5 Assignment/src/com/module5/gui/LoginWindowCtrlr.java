package com.module5.gui;

import java.io.IOException;

import com.module5.db.DBHandler;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LoginWindowCtrlr {

    private String loggedInUser;

    @FXML private TextField usrnameTF;
    @FXML private TextField passTF;

    @FXML private Button loginBtn;

    private void loadAdminWindow(){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/adminWindow.fxml"));
            Parent parent = loader.load();
            AdminWindowCtrlr adminController = loader.getController();
            adminController.setLoggedInUser(loggedInUser); // Pass logged-in username cuz program is stoopid
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Admin");
            stage.setScene(new Scene(parent));
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Obvious
    private void closeWindow() {
        Stage stage = (Stage) loginBtn.getScene().getWindow();
        stage.close();
    }

    public void login() {
        // Obtain submitted password and username from the textfields
        String submittedUser = usrnameTF.getText();
        String submittedPass = passTF.getText();

        // Check submitted credentials
        boolean isAuthenticated = DBHandler.authenticateUser(submittedUser, submittedPass);

        // If credentials are valid load admin window if not alert user that their login is wrong
        if (isAuthenticated) {
            loggedInUser = submittedUser; // Store logged-in user's name in the static variable
            closeWindow();
            loadAdminWindow();
            System.out.println("Successfully logged in user: " + submittedUser);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Invalid Credentials");
            alert.setHeaderText("Login Failed");
            System.out.println("Invalid login combination");
            alert.showAndWait();
        }
    }

    public void opensLink(ActionEvent event) {
        try {
            Runtime.getRuntime().exec("cmd.exe /c start https://www.youtube.com/watch?v=dQw4w9WgXcQ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
