package com.example.javafxapp.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HomeController {

    @FXML
    private void handleUpdateEmployee() throws Exception {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/fxml/UpdateEmployee.fxml"))));
        stage.setTitle("Update Employee Data");
        stage.show();
    }

    @FXML
    private void handleCreateEmployee() throws Exception {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/fxml/NewEmployee.fxml"))));
        stage.setTitle("Create New Employee");
        stage.show();
    }

    @FXML
    private void handleDeleteEmployee() throws Exception {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/fxml/DeleteEmployee.fxml"))));
        stage.setTitle("Delete Existing Employee");
        stage.show();
    }
}
