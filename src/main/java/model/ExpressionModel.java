package model;

import java.util.List;

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
}
