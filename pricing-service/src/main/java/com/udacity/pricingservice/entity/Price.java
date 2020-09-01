package com.udacity.pricingservice.entity;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Represents the price of a given vehicle, including currency.
 */
@Entity
public class Price {

    @Id
    @Column(name = "VEHICLE_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long vehicleId;

    private String currency;
    private BigDecimal price;

    public Price() {
    }

    public Price(Long vehicleId, String currency, BigDecimal price) {
        this.vehicleId = vehicleId;
        this.currency = currency;
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicle) {
        this.vehicleId = vehicle;
    }
}
