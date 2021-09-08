package com.epam.jwd.interpreter.factory;

import java.util.HashMap;
import java.util.Map;

public class OperationPriorityFactory implements PriorityFactory {

    private static volatile OperationPriorityFactory instance;

    private static final Map<String, Integer> operatorMap = new HashMap<>();

    private OperationPriorityFactory() {
        operatorMap.put("|", 6);
        operatorMap.put("^", 7);
        operatorMap.put("&", 8);
        operatorMap.put(">>", 11);
        operatorMap.put("<<", 11);
        operatorMap.put("~", 14);
    }

    public static OperationPriorityFactory getInstance() {
        if (instance == null) {
            synchronized (OperationPriorityFactory.class) {
                if (instance == null) {
                    instance = new OperationPriorityFactory();
                }
            }
        }
        return instance;
    }

    @Override
    public int getPriority(String key) {
        return operatorMap.get(key);
    }
}
