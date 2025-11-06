package application.controller;

import application.model.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class ViewMembersController {

    @FXML
    private VBox plansContainer;

    @FXML
    private Button themeToggleButton;

    private boolean isDarkMode = false;

    private final Map<String, MembershipPlan> plans = new LinkedHashMap<>();

    @FXML
    public void initialize() {
        // Initialize available plans
        plans.put("Basic", new BasicPlan());
        plans.put("Premium", new PremiumPlan());
        plans.put("VIP", new VIPPlan());

        loadPlans();
    }

    private void loadPlans() {
        plansContainer.getChildren().clear();

        for (MembershipPlan plan : plans.values()) {
            VBox planBox = new VBox(8);
            planBox.setStyle("-fx-background-color: white; -fx-background-radius: 10; "
                    + "-fx-padding: 15; -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.2), 5, 0, 0, 2);");
            planBox.setPrefWidth(480);

            Label planTitle = new Label(plan.getPlanName() + " Plan");
            planTitle.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #34495e;");

            VBox pricingBox = new VBox(5);
            plan.getPricing().forEach((duration, price) -> {
                Label label = new Label(duration + " → ₹" + price);
                label.setStyle("-fx-font-size: 14px; -fx-text-fill: #2c3e50;");
                pricingBox.getChildren().add(label);
            });

            planBox.getChildren().addAll(planTitle, pricingBox);
            plansContainer.getChildren().add(planBox);
        }
    }

    @FXML
    private void goBack() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/resources/start.fxml"));
            Stage stage = (Stage) plansContainer.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.show(); // ✅ ensures it updates correctly
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
