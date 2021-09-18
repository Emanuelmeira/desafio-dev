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

    private final String signal ;
    private final Integer value;

    OperationType(Integer value, String signal) {
        this.value = value;
        this.signal = signal;
    }

    public static OperationType getEnumFromNumType(int numOperation) {

        return Arrays.stream(OperationType.values())
                .filter(operation -> operation.value.equals(numOperation))
                .findFirst()
                .orElseThrow();
    }

    public Integer getValue() {
        return value;
    }

    public String getSignal() {
        return signal;
    }

    public boolean getSignalLikeBoolean() {
        return this.getSignal().equals("+");
    }

}
