package com.epam.jwd.model;

import java.util.List;
import java.util.Objects;

public class ExpressionModel implements SpeechModel {
    private String expr;

    ExpressionModel() {
    }

    ExpressionModel(String expr) {
        this.expr = expr;
    }

    @Override
    public void print() {
        System.out.print(expr);
    }

    @Override
    public void add(SpeechModel component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(SpeechModel component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<SpeechModel> getComponents() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Integer speechLength() {
        return 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExpressionModel that = (ExpressionModel) o;
        return Objects.equals(expr, that.expr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expr);
    }

    @Override
    public String toString() {
        return "ExpressionModel{" +
                "expr='" + expr + '\'' +
                '}';
    }
}
