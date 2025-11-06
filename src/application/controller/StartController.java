package application.controller;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartController {

    @FXML
    private Button themeToggleButton;

    private boolean isDarkMode = false;


    @FXML
    private void openPlanDetails(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/resources/viewmembers.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Membership Plans");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void openRegisterMember(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/resources/registration.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Register Member");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
