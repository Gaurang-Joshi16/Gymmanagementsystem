package application.controller;


import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import application.model.*;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class RegistrationController {

    @FXML
    private Button themeToggleButton;

    private boolean isDarkMode = false;

    @FXML
    private TextField nameField, emailField, phoneField;

    @FXML
    private ChoiceBox<String> membershipTypeChoice, membershipDurationChoice;

    @FXML
    private Label amountLabel;

    private final Map<String, MembershipPlan> plans = new HashMap<>();

    @FXML
    public void initialize() {
        // Register plan objects
        plans.put("Basic", new BasicPlan());
        plans.put("Premium", new PremiumPlan());
        plans.put("VIP", new VIPPlan());

        membershipTypeChoice.getItems().addAll(plans.keySet());
        membershipDurationChoice.getItems().addAll("1 Month", "3 Months", "6 Months", "12 Months");

        amountLabel.setText("Amount: ");
    }

    @FXML
    private void updatePlanOptions() {
        membershipDurationChoice.getSelectionModel().clearSelection();
        amountLabel.setText("Amount: ");
    }

    @FXML
    private void updateAmount() {
        String type = membershipTypeChoice.getValue();
        String duration = membershipDurationChoice.getValue();

        if (type != null && duration != null) {
            MembershipPlan plan = plans.get(type);
            if (plan != null) {
                int amount = plan.getPrice(duration);
                amountLabel.setText("Amount: ₹" + amount);
            }
        }
    }

    @FXML
    private void registerMember() {
        String name = nameField.getText();
        String email = emailField.getText();
        String phone = phoneField.getText();
        String type = membershipTypeChoice.getValue();
        String duration = membershipDurationChoice.getValue();
        String amount = amountLabel.getText().replace("Amount: ₹", "");

        if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || type == null || duration == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please fill all details!");
            alert.show();
            return;
        }

        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
        confirm.setHeaderText("Do you want to register?");
        confirm.showAndWait().ifPresent(response -> {
            try (PrintWriter out = new PrintWriter(new FileWriter("members.txt", true))) {
                out.println(name + " | " + email + " | " + phone + " | " + type + " | " + duration + " | ₹" + amount);
                Alert success = new Alert(Alert.AlertType.INFORMATION);
                success.setContentText("Registered Successfully for " + duration + " (" + type + ")");
                success.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
