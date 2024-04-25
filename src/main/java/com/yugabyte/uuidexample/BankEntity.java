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

    @Column(name = "BANK_NAME")
    @Convert(converter = UuidConverter.class)
    private String bankName;

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

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
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
