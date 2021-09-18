package com.bycoders.test.domain.enums;

import java.util.Arrays;

public enum OperationType {

    DEBIT(1, "+"),
    TICKET(2, "-"),
    FINANCING(3, "-"),
    CREDIT(4, "+"),
    LOAN_RECEIPT(5, "+"),
    SALES(6, "+"),
    TED(7, "+"),
    DOC(8, "+"),
    RENT(9, "-");

    private String value;
    private Integer signal;

    OperationType(Integer signal, String value) {
        this.value = value;
        this.signal = signal;
    }

    public static OperationType getEnumFromNumType(int numOperation) {

        return Arrays.stream(OperationType.values())
                .filter(operation -> operation.signal.equals(numOperation))
                .findFirst()
                .orElseThrow();
    }
}
