package com.udea.droolrules.model;

import java.util.ArrayList;
import java.util.List;

public class AirlineResponse {

    private boolean upgradeToBusiness = false;
    private boolean priorityCheckIn = false;
    private double discount = 0.0;
    private boolean eligibleForUpgrade = true;
    private String assignedSeat = "";
    private double compensation = 0.0;
    private int loyaltyPoints = 0;
    private boolean luggageAllowed = true;
    private boolean vipLoungeAccess = false;
    private List<String> messages = new ArrayList<>();

    public AirlineResponse() {
    }

    public AirlineResponse(boolean upgradeToBusiness, boolean priorityCheckIn, double discount,
                           boolean eligibleForUpgrade, String assignedSeat, double compensation,
                           int loyaltyPoints, boolean luggageAllowed, boolean vipLoungeAccess,
                           List<String> messages) {
        this.upgradeToBusiness = upgradeToBusiness;
        this.priorityCheckIn = priorityCheckIn;
        this.discount = discount;
        this.eligibleForUpgrade = eligibleForUpgrade;
        this.assignedSeat = assignedSeat;
        this.compensation = compensation;
        this.loyaltyPoints = loyaltyPoints;
        this.luggageAllowed = luggageAllowed;
        this.vipLoungeAccess = vipLoungeAccess;
        this.messages = messages;
    }

    public boolean isUpgradeToBusiness() {
        return upgradeToBusiness;
    }

    public void setUpgradeToBusiness(boolean upgradeToBusiness) {
        this.upgradeToBusiness = upgradeToBusiness;
    }

    public boolean isPriorityCheckIn() {
        return priorityCheckIn;
    }

    public void setPriorityCheckIn(boolean priorityCheckIn) {
        this.priorityCheckIn = priorityCheckIn;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public boolean isEligibleForUpgrade() {
        return eligibleForUpgrade;
    }

    public void setEligibleForUpgrade(boolean eligibleForUpgrade) {
        this.eligibleForUpgrade = eligibleForUpgrade;
    }

    public String getAssignedSeat() {
        return assignedSeat;
    }

    public void setAssignedSeat(String assignedSeat) {
        this.assignedSeat = assignedSeat;
    }

    public double getCompensation() {
        return compensation;
    }

    public void setCompensation(double compensation) {
        this.compensation = compensation;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    public boolean isLuggageAllowed() {
        return luggageAllowed;
    }

    public void setLuggageAllowed(boolean luggageAllowed) {
        this.luggageAllowed = luggageAllowed;
    }

    public boolean isVipLoungeAccess() {
        return vipLoungeAccess;
    }

    public void setVipLoungeAccess(boolean vipLoungeAccess) {
        this.vipLoungeAccess = vipLoungeAccess;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }
}
