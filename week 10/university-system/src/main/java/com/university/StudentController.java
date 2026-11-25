
package com.university;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.concurrent.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class StudentController {

    @FXML
    private TextField regNumberField;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField emailField;

    @FXML
    private TableView<Student> studentTable;

    @FXML
    private TableColumn<Student, Integer> idColumn;

    @FXML
    private TableColumn<Student, String> regColumn;

    @FXML
    private TableColumn<Student, String> firstNameColumn;

    @FXML
    private TableColumn<Student, String> lastNameColumn;

    @FXML
    public void initialize() {

        idColumn.setCellValueFactory(
                cell -> cell.getValue().idProperty().asObject());

        regColumn.setCellValueFactory(
                cell -> cell.getValue().regNumberProperty());

        firstNameColumn.setCellValueFactory(
                cell -> cell.getValue().firstNameProperty());

        lastNameColumn.setCellValueFactory(
                cell -> cell.getValue().lastNameProperty());

        loadStudents();
    }

    private void loadStudents() {

        LoadStudentsTask task = new LoadStudentsTask();

        task.setOnSucceeded(event -> {
            studentTable.setItems(task.getValue());
        });

        task.setOnFailed(event -> {
            showAlert("Loading Error",
                    task.getException().getMessage());
        });

        Thread thread = new Thread(task);
        thread.setDaemon(true);
        thread.start();
    }

    @FXML
    private void handleSaveStudent() {

        String regNumber = regNumberField.getText().trim();
        String firstName = firstNameField.getText().trim();
        String lastName = lastNameField.getText().trim();
        String email = emailField.getText().trim();

        if (regNumber.isEmpty() || firstName.isEmpty()
                || lastName.isEmpty() || email.isEmpty()) {

            showAlert("Input Error",
                    "Please fill in all student details.");
            return;
        }

        if (!email.contains("@") || !email.contains(".")) {
            showAlert("Input Error",
                    "Please enter a valid email address.");
            return;
        }

        Task<Void> saveTask = new Task<>() {

            @Override
            protected Void call() throws Exception {

                String sql = "INSERT INTO students "
                        + "(registration_number, first_name, last_name, email) "
                        + "VALUES (?, ?, ?, ?)";

                try (Connection connection =
                             DatabaseUtil.getConnection();
                     PreparedStatement statement =
                             connection.prepareStatement(sql)) {

                    statement.setString(1, regNumber);
                    statement.setString(2, firstName);
                    statement.setString(3, lastName);
                    statement.setString(4, email);

                    statement.executeUpdate();
                }

                return null;
            }
        };

        saveTask.setOnSucceeded(event -> {

            showAlert("Success",
                    "Student saved successfully!");

            regNumberField.clear();
            firstNameField.clear();
            lastNameField.clear();
            emailField.clear();

            loadStudents();
        });

        saveTask.setOnFailed(event -> {

            showAlert("Database Error",
                    saveTask.getException().getMessage());
        });

        Thread thread = new Thread(saveTask);
        thread.setDaemon(true);
        thread.start();
    }

    private void showAlert(String title, String message) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}


