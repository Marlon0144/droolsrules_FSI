package com.udea.droolrules.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class AirlineRequest {

    @NotNull(message = "Los datos del pasajero son obligatorios")
    @Valid
    private Passenger passenger;

    @NotNull(message = "Los datos del vuelo son obligatorios")
    @Valid
    private Flight flight;

    @NotNull(message = "El peso del equipaje es obligatorio")
    @Min(value = 0, message = "El peso del equipaje no puede ser negativo")
    private double luggageWeightKg;

    public AirlineRequest() {
    }

    public AirlineRequest(Passenger passenger, Flight flight, double luggageWeightKg) {
        this.passenger = passenger;
        this.flight = flight;
        this.luggageWeightKg = luggageWeightKg;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public double getLuggageWeightKg() {
        return luggageWeightKg;
    }

    public void setLuggageWeightKg(double luggageWeightKg) {
        this.luggageWeightKg = luggageWeightKg;
    }
}
