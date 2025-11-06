package application.model;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class MembershipPlan {
    protected String planName;
    protected Map<String, Integer> pricing = new LinkedHashMap<>();

    public String getPlanName() {
        return planName;
    }

    public int getPrice(String duration) {
        return pricing.getOrDefault(duration, 0);
    }

    public Map<String, Integer> getPricing() {
        return pricing;
    }

    public String getPlanDetails() {
        StringBuilder sb = new StringBuilder(planName + " Plan Pricing:\n");
        pricing.forEach((duration, price) -> sb.append(duration)
                .append(" → ₹")
                .append(price)
                .append("\n"));
        return sb.toString();
    }
}
