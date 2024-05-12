package com.module5.gui;

import com.module5.db.DBHandler;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminWindowCtrlr {

    private String loggedInUser; // Variable to store logged-in user's name

    @FXML private Button logoutBtn;

    @FXML private Label welcomeLabel;

    @FXML private TableView<User> tableView;

    @FXML private TableColumn<User, Integer> idCol;
    @FXML private TableColumn<User, String> userCol;
    @FXML private TableColumn<User, String> passCol;

    private ObservableList<User> userList = FXCollections.observableArrayList();


    public void initialize() {
        // Initialize table columns
        idCol.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        userCol.setCellValueFactory(cellData -> cellData.getValue().usernameProperty());
        passCol.setCellValueFactory(cellData -> cellData.getValue().passwordProperty());

        // Load data into TableView
        loadDataFromDatabase();
    }

    // Gets data from the DB for the tableview
    public void loadDataFromDatabase() {
        userList.clear(); // Clear existing data

        // Retrieve data from the database
        try {
            ResultSet resultSet = DBHandler.getAllUsers(); // Assuming you have a method to retrieve all users from the database
            if (resultSet != null) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String username = resultSet.getString("username");
                    String password = resultSet.getString("password");
                    userList.add(new User(id, username, password));
                }
                // Close the ResultSet after retrieving data
                resultSet.close();
            } else {
                System.err.println("ResultSet is null");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Set the items of the TableView
        tableView.setItems(userList);
    }

    // Loads user editor/manager popup
    public void loadUserManagerWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/userManagerWindow.fxml"));
            Parent parent = loader.load();
            UserManagerWindowCtrlr controller = loader.getController();
            controller.setAdminWindowCtrlr(this); // Set the reference to this AdminWindowCtrlr
            controller.setLoggedInUser(loggedInUser);
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Edit");
            stage.setScene(new Scene(parent));
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Loads the login window
    private void loadLoginWindow(){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/loginWindow.fxml"));
            Parent parent = loader.load();
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Login");
            stage.setScene(new Scene(parent));
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Obvious
    private void closeWindow() {
        Stage stage = (Stage) logoutBtn.getScene().getWindow();
        stage.close();
    }

    // glorified closeWindow
    public void logout() {
        closeWindow();
        loadLoginWindow();
        System.out.println("Logged out user: " + loggedInUser); // Print logged-out user's name
    }

    // double whammy sets logged-in user and updates the label that displays users name
    public void setLoggedInUser(String loggedInUser) {
        this.loggedInUser = loggedInUser;
        updateWelcomeLabel();
    }

    private void updateWelcomeLabel() {
        welcomeLabel.setText(loggedInUser);
    }
}
