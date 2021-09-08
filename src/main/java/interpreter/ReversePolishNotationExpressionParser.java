package interpreter;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public enum ReversePolishNotationExpressionParser implements ExpressionParser {
    INSTANCE;

    private static final Expression BITWISE_XOR = context -> context.push(context.pop() ^ context.pop());
    private static final Expression BITWISE_AND = context -> context.push(context.pop() & context.pop());
    private static final Expression BITWISE_OR = context -> context.push(context.pop() | context.pop());
    private static final Expression BITWISE_NO = context -> context.push(~context.pop());
    private static final Expression SHIFT_RIGHT = context -> {
        final int secondNUmber = context.pop();
        context.push(context.pop() >> secondNUmber);
    };
    private static final Expression SHIFT_LEFT = context -> {
        final int secondNUmber = context.pop();
        context.push(context.pop() << secondNUmber);
    };


    @Override
    public Expression parse(String expression) {
        List<Expression> expressions = new LinkedList<>();
        for (String lexeme : expression.split("\\p{Blank}+")
        ) {
            switch (lexeme) {
                case BitwiseOperation.BITWISE_XOR:
                    expressions.add(BITWISE_XOR);
                    break;
                case BitwiseOperation.BITWISE_AND:
                    expressions.add(BITWISE_AND);
                    break;
                case BitwiseOperation.BITWISE_OR:
                    expressions.add(BITWISE_OR);
                    break;
                case BitwiseOperation.BITWISE_NO:
                    expressions.add(BITWISE_NO);
                    break;
                case BitwiseOperation.SHIFT_RIGHT:
                    expressions.add(SHIFT_RIGHT);
                    break;
                case BitwiseOperation.SHIFT_LEFT:
                    expressions.add(SHIFT_LEFT);
                    break;
                default:
                    final Scanner scanner = new Scanner(lexeme);
                    if (scanner.hasNextInt()) {
                        expressions.add(new NumbersFromExpression(scanner.nextInt()));
                    }
                    break;
            }
        }
        return context -> {
            for (Expression e : expressions
            ) {
                e.interpret(context);
            }
        };
    }
}
