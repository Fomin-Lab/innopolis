package ru.innopolis.university.fomin.math;

public class Number {
    protected int v;

    public Number(int v) {
        this.v = v;
    }

    public int get() {
        return this.v;
    }

    public void divide(int divider) {
        this.v = this.v / divider;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj instanceof Number) {
            return ((Number) obj).get() == this.v;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "" + this.v;
    }
}
