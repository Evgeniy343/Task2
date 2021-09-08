package interpreter;

public class NumbersFromExpression implements Expression {

    private final int value;

    public NumbersFromExpression(int value) {
        this.value = value;
    }

    @Override
    public void interpret(ExpressionContext context) {
        context.push(value);
    }

    @Override
    public String toString() {
        return "ExpressionNumber{" +
                "value=" + value +
                '}';
    }
}
