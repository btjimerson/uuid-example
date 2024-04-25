package com.yugabyte.uuidexample;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "bank")
public class BankEntity {

    @Id
    @Column(name = "BANK_ID", updatable = false)
    private String bankId;

    @Column(name = "BANK_LOCATION_ID")
    @Convert(converter = UuidConverter.class)
    private String bankLocationId;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STATE")
    private String state;

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public String getBankLocationId() {
        return bankLocationId;
    }

    public void setBankLocationId(String bankLocationId) {
        this.bankLocationId = bankLocationId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
