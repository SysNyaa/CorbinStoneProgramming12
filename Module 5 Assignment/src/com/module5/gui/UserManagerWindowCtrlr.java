package com.module5.gui;

import com.module5.db.DBHandler;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class UserManagerWindowCtrlr {

    private String loggedInUser; // Variable to store logged-in user's name
    private AdminWindowCtrlr adminWindowCtrlr;

    @FXML private TextField userTF;
    @FXML private TextField passTF;

    public void setAdminWindowCtrlr(AdminWindowCtrlr adminWindowCtrlr) {
        this.adminWindowCtrlr = adminWindowCtrlr;
    }

    // Reloads the tableview with DB data
    private void reloadTable() {
        if (adminWindowCtrlr != null) {
            adminWindowCtrlr.loadDataFromDatabase();
        }
    }

    // called on action when button to add users to database is pressed
    public void addUser() {
        String submittedUser = userTF.getText();
        String submittedPass = passTF.getText();

        // Check if the user already exists in the database
        boolean userExists = DBHandler.userExists(submittedUser);

        if (!userExists) {
            // Add user to database
            DBHandler.addUser(submittedUser, submittedPass);
            reloadTable();
        } else {
            // User already exists, display error popup
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("User already exists.");
            alert.setHeaderText("Failed to add user");
            alert.showAndWait();
        }
    }

    // called on action when button to remove users to database is pressed
    public void removeUser() {
        String submittedUser = userTF.getText();

        if (!loggedInUser.equals(submittedUser)) {
            // Remove the submitted user
            DBHandler.rmUser(submittedUser);
            reloadTable();
        } else {
            // User is trying to remove themself, display error popup
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("You cannot remove yourself.");
            alert.setHeaderText("Failed to remove user");
            alert.showAndWait();
        }
    }

    // called on action when button to change users passwords in the database is pressed
    public void changePass() {
        String submittedUser = userTF.getText();
        String submittedPass = passTF.getText();

        // Check if the user already exists in the database
        boolean userExists = DBHandler.userExists(submittedUser);

        if (userExists) {
            // Change password of user
            DBHandler.changeUserPass(submittedUser, submittedPass);
            reloadTable();
        } else {
            // User already exists, display error popup
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("User does not exists.");
            alert.setHeaderText("Failed change password");
            alert.showAndWait();
        }
    }

    public void setLoggedInUser(String loggedInUser) {
        this.loggedInUser = loggedInUser;
    }
}
