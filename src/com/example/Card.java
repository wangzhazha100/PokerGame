package com.example;

public class Card {
    private int value; // 牌的值，包含花色和数字的十六进制值

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Card(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("0x%X", value);
    }
}
