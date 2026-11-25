
package com.university;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoadStudentsTask extends Task<ObservableList<Student>> {

    @Override
    protected ObservableList<Student> call() throws Exception {

        ObservableList<Student> students =
                FXCollections.observableArrayList();

        String sql = "SELECT student_id, registration_number, "
                + "first_name, last_name FROM students";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {

                Student student = new Student(
                        resultSet.getInt("student_id"),
                        resultSet.getString("registration_number"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name")
                );

                students.add(student);
            }
        }

        return students;
    }
}

