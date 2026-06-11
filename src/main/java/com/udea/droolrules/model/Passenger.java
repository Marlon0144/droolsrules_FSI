package com.udea.droolrules.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Passenger {

    @NotNull(message = "La edad del pasajero es obligatoria")
    @Min(value = 0, message = "La edad del pasajero no puede ser negativa")
    private int age;

    @NotBlank(message = "El tipo de membresía es obligatorio (Ej: Basic, Gold, Platinum)")
    private String membership;

    private boolean travelingWithChildren;

    @NotBlank(message = "La preferencia de asiento es obligatoria (Ej: Any, Window, Aisle)")
    private String seatPreference;

    public Passenger() {
    }

    public Passenger(int age, String membership, boolean travelingWithChildren, String seatPreference) {
        this.age = age;
        this.membership = membership;
        this.travelingWithChildren = travelingWithChildren;
        this.seatPreference = seatPreference;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMembership() {
        return membership;
    }

    public void setMembership(String membership) {
        this.membership = membership;
    }

    public boolean isTravelingWithChildren() {
        return travelingWithChildren;
    }

    public void setTravelingWithChildren(boolean travelingWithChildren) {
        this.travelingWithChildren = travelingWithChildren;
    }

    public String getSeatPreference() {
        return seatPreference;
    }

    public void setSeatPreference(String seatPreference) {
        this.seatPreference = seatPreference;
    }
}
