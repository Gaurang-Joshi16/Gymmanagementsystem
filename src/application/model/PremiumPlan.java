package application.model;

public class PremiumPlan extends MembershipPlan {

    public PremiumPlan() {
        planName = "Premium";
        pricing.put("1 Month", 1000);
        pricing.put("3 Months", 2800);
        pricing.put("6 Months", 5400);
        pricing.put("12 Months", 10000);
    }
}
