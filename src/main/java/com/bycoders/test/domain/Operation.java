package com.bycoders.test.domain;

import com.bycoders.test.domain.enums.OperationType;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@Table(name = "OPERATION", schema = "public")
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "operation_type")
    @Enumerated(EnumType.STRING)
    private OperationType operationType;
    @Column(name = "date_operation")
    private LocalDate dateOfOperation;
    @Column(name = "value_operation")
    private Double valueOfOperation;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "card")
    private String card;
    @Column(name = "time_operation")
    private LocalTime timeOfOperation;
    @Column(name = "store_owner_operation")
    private String storeOwnerOperation;
    @Column(name = "store_name_operation")
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
