package com.example.javafxapp.controllers;

import com.example.javafxapp.utils.DatabaseHelper;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteEmployeeController {

    @FXML
    private TextField empIdField;

    @FXML
    private Label messageLabel;

    @FXML
    private void handleDeleteEmployee() {
        try {
            int empId = Integer.parseInt(empIdField.getText());

            Connection connection = DatabaseHelper.getConnection();

            // Delete employee data
            PreparedStatement statement = connection.prepareStatement("DELETE FROM employees WHERE id = ?");
            statement.setInt(1, empId);
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                messageLabel.setText("Employee deleted successfully!");
            } else {
                messageLabel.setText("Employee not found!");
            }

        } catch (Exception e) {
            messageLabel.setText("Error: " + e.getMessage());
        }
    }
}
