package model;

public class ExpressionsModel implements SpeechModel {
    private String expr;

    public ExpressionsModel(String expr) {
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
