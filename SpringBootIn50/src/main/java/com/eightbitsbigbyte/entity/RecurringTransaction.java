package com.eightbitsbigbyte.entity;

public class RecurringTransaction {
    private int frequency;
    private long amount;

    public RecurringTransaction(int frequency, long amount) {
        this.frequency = frequency;
        this.amount = amount;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }
}
