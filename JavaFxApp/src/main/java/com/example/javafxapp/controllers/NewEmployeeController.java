package com.example.javafxapp.controllers;

import com.example.javafxapp.utils.DatabaseHelper;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class NewEmployeeController {

    @FXML
    private TextField empIdField, nameField, addressField, phoneField, deptNoField, deptNameField, salaryField;

    @FXML
    private Label messageLabel;

    @FXML
    private void handleAddEmployee() {
        try {
            int empId = Integer.parseInt(empIdField.getText());
            String name = nameField.getText();
            String address = addressField.getText();
            String phone = phoneField.getText();
            String deptNo = deptNoField.getText();
            String deptName = deptNameField.getText();
            double salary = Double.parseDouble(salaryField.getText());

            Connection connection = DatabaseHelper.getConnection();

            // Insert new employee data
            PreparedStatement statement = connection.prepareStatement("INSERT INTO employees (id, name, address, phone, department_no, department_name, salary) VALUES (?, ?, ?, ?, ?, ?, ?)");
            statement.setInt(1, empId);
            statement.setString(2, name);
            statement.setString(3, address);
            statement.setString(4, phone);
            statement.setString(5, deptNo);
            statement.setString(6, deptName);
            statement.setDouble(7, salary);
            statement.executeUpdate();

            messageLabel.setText("Employee added successfully!");

        } catch (Exception e) {
            messageLabel.setText("Error: " + e.getMessage());
        }
    }
}
