package application.model;

public class BasicPlan extends MembershipPlan {

    public BasicPlan() {
        planName = "Basic";
        pricing.put("1 Month", 500);
        pricing.put("3 Months", 1400);
        pricing.put("6 Months", 2700);
        pricing.put("12 Months", 5000);
    }
}
