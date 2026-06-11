package com.udea.droolrules.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class Flight {

    @NotNull(message = "Los minutos de retraso del vuelo son obligatorios")
    @Min(value = 0, message = "Los minutos de retraso no pueden ser negativos")
    private int delayMinutes;

    @NotNull(message = "La duración del vuelo en horas es obligatoria")
    @Min(value = 0, message = "La duración del vuelo no puede ser negativa")
    private double durationHours;

    private boolean emergencySeatAvailable;

    public Flight() {
    }

    public Flight(int delayMinutes, double durationHours, boolean emergencySeatAvailable) {
        this.delayMinutes = delayMinutes;
        this.durationHours = durationHours;
        this.emergencySeatAvailable = emergencySeatAvailable;
    }

    public int getDelayMinutes() {
        return delayMinutes;
    }

    public void setDelayMinutes(int delayMinutes) {
        this.delayMinutes = delayMinutes;
    }

    public double getDurationHours() {
        return durationHours;
    }

    public void setDurationHours(double durationHours) {
        this.durationHours = durationHours;
    }

    public boolean isEmergencySeatAvailable() {
        return emergencySeatAvailable;
    }

    public void setEmergencySeatAvailable(boolean emergencySeatAvailable) {
        this.emergencySeatAvailable = emergencySeatAvailable;
    }
}
