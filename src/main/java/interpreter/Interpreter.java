package interpreter;

public interface Interpreter {
    Integer execute(String expression);

    static Interpreter newInstance(){
        return ExpressionInterpreter.getInstance();
    }
}
