package com.example.javafxapp.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    public void addEmployee(String name, String address, String phone, int departmentNo, String departmentName, double salary) throws Exception {
        String query = "INSERT INTO employees (name, address, phone, department_no, department_name, salary) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = DatabaseHelper.getConnection(); PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, name);
            pst.setString(2, address);
            pst.setString(3, phone);
            pst.setInt(4, departmentNo);
            pst.setString(5, departmentName);
            pst.setDouble(6, salary);
            pst.executeUpdate();
        }
    }

}
