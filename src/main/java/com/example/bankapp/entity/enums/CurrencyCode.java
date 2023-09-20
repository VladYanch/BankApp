package com.example.bankapp.entity.enums;

public enum CurrencyCode {
    EUR(1),
    USD(2),
    UAH(3);
    private final int value;
    CurrencyCode(int value) {
        this.value = value;
    }
}
