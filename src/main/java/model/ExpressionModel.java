package model;

public class ExpressionModel implements SpeechModel {
    private String expr;

    public ExpressionModel(String expr) {
        this.expr = expr;
    }

    @Override
    public void print() {
        System.out.println(expr);
    }

    @Override
    public void add(SpeechModel component) {

    }

    @Override
    public void remove(SpeechModel component) {

    }
}
