package application.model;

public class VIPPlan extends MembershipPlan {

    public VIPPlan() {
        planName = "VIP";
        pricing.put("1 Month", 2000);
        pricing.put("3 Months", 5500);
        pricing.put("6 Months", 10000);
        pricing.put("12 Months", 18000);
    }
}
