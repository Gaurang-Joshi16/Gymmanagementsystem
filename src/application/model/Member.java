package application.model;

public class Member {
    private String name;
    private String email;
    private String membershipType;
    private int duration; // in months
    private double amount;

    public Member(String name, String email, String membershipType, int duration, double amount) {
        this.name = name;
        this.email = email;
        this.membershipType = membershipType;
        this.duration = duration;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return name + " | " + email + " | " + membershipType + " | " + duration + " month(s) | $" + amount;
    }

    // Getters
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getMembershipType() { return membershipType; }
    public int getDuration() { return duration; }
    public double getAmount() { return amount; }
}
