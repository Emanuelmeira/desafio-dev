package com.bycoders.test.domain;

import com.bycoders.test.domain.enums.OperationType;

import java.time.LocalDate;
import java.time.LocalTime;

public class Operation {

    private OperationType operationType;
    private LocalDate dateOfOperation;
    private Double valueOfOperation;
    private String cpf;
    private String card;
    private LocalTime timeOfOperation;
    private String storeOwnerOperation;
    private String storeNameOperation;

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

    public LocalDate getDateOfOperation() {
        return dateOfOperation;
    }

    public void setDateOfOperation(LocalDate dateOfOperation) {
        this.dateOfOperation = dateOfOperation;
    }

    public Double getValueOfOperation() {
        return valueOfOperation;
    }

    public void setValueOfOperation(Double valueOfOperation) {
        this.valueOfOperation = valueOfOperation;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public LocalTime getTimeOfOperation() {
        return timeOfOperation;
    }

    public void setTimeOfOperation(LocalTime timeOfOperation) {
        this.timeOfOperation = timeOfOperation;
    }

    public String getStoreOwnerOperation() {
        return storeOwnerOperation;
    }

    public void setStoreOwnerOperation(String storeOwnerOperation) {
        this.storeOwnerOperation = storeOwnerOperation;
    }

    public String getStoreNameOperation() {
        return storeNameOperation;
    }

    public void setStoreNameOperation(String storeNameOperation) {
        this.storeNameOperation = storeNameOperation;
    }
}
