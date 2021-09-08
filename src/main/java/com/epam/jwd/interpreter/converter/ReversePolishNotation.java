package com.epam.jwd.interpreter.converter;

import com.epam.jwd.interpreter.factory.OperationPriorityFactory;
import com.epam.jwd.interpreter.factory.PriorityFactory;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum ReversePolishNotation implements ReversePolishNotationConverter {
    INSTANCE;

    private final Pattern pattern = Pattern.compile("[~&|^()]|[<>]{2}|\\d+");
    private final StringBuilder result = new StringBuilder();
    private final Pattern digitPattern = Pattern.compile("\\d+");
    private final PriorityFactory priorityFactory = OperationPriorityFactory.getInstance();

    @Override
    public String convert(String expression) {

        Deque<String> lexemeStack = new LinkedList<>();
        Matcher matcher = pattern.matcher(expression);

        List<String> lexemes = new ArrayList<>();
        while (matcher.find()) {
            lexemes.add(matcher.group());
        }

        for (String lexeme : lexemes
        ) {
            if (isDigit(lexeme)) {
                appendLexeme(lexeme);
            } else {
                while (isUnloading(lexeme, lexemeStack)) {
                    appendLexeme(lexemeStack.pop());
                }
                if (!lexeme.equals(")")) {
                    lexemeStack.push(lexeme);
                }
            }
        }

        unloadingFromStack(lexemeStack);

        String reversePolishNotation = this.result.toString();
        result.setLength(0);
        return reversePolishNotation;
    }

    private void appendLexeme(String lexeme) {
        result.append(lexeme).append(" ");
    }

    private boolean isDigit(String lexeme) {
        Matcher digitMatcher = digitPattern.matcher(lexeme);
        return digitMatcher.matches();
    }

    private boolean isUnloading(String lexeme, Deque<String> lexemeStack) {

        if (lexeme.equals(")")) {
            unloadingFromStack(lexemeStack);
            return false;
        } else if (!lexemeStack.isEmpty()) {
            if (lexeme.equals("(") || lexemeStack.peek().equals("(")) {
                return false;
            }
            return priorityFactory.getPriority(lexeme) <= priorityFactory.getPriority(lexemeStack.peek());
        } else {
            return false;
        }
    }

    private void unloadingFromStack(Deque<String> lexemeStack) {
        while (!lexemeStack.isEmpty()) {
            if (lexemeStack.peek().equals("(")) {
                lexemeStack.pop();
                break;
            } else {
                appendLexeme(lexemeStack.pop());
            }
        }
    }
}
