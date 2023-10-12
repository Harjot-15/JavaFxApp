package com.example.javafxapp.controllers;

import com.example.javafxapp.utils.DatabaseHelper;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UpdateEmployeeController {

    @FXML
    private TextField empIdField;

    @FXML
    private TextField incrementField;

    @FXML
    private Label messageLabel;

    @FXML
    private void handleUpdateSalary() {
        try {
            int empId = Integer.parseInt(empIdField.getText());
            double incrementPercentage = Double.parseDouble(incrementField.getText());

            Connection connection = DatabaseHelper.getConnection();

            // Fetch current salary
            PreparedStatement statement = connection.prepareStatement("SELECT salary FROM employees WHERE id = ?");
            statement.setInt(1, empId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                double currentSalary = resultSet.getDouble("Salary");
                double newSalary = currentSalary + (currentSalary * incrementPercentage / 100);

                // Update the salary
                statement = connection.prepareStatement("UPDATE employees SET salary = ? WHERE id = ?");
                statement.setDouble(1, newSalary);
                statement.setInt(2, empId);
                statement.executeUpdate();

                messageLabel.setText("Salary updated successfully!");
            } else {
                messageLabel.setText("Employee not found!");
            }

        } catch (Exception e) {
            messageLabel.setText("Error: " + e.getMessage());
        }
    }
}
