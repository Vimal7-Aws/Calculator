package anz.com.au.strategy;

import java.util.HashMap;
import java.util.Map;

import anz.com.au.operations.MathOperation;


public final class StrategyFactory {

    private static Map<String, OperationStrategy> strategies =
            new HashMap<>();

    private StrategyFactory() {

    }

    static {
        strategies.put(MathOperation.ADD.name(),
                new AddStrategy());
        strategies.put(MathOperation.MULTIPLY.name(),
                new MultiplyStrategy());
        strategies.put(MathOperation.DIVIDE.name(),
                new DivideStrategy());
        strategies.put(MathOperation.SUBTRACT.name(),
                new SubtractStrategy());
        strategies.put(MathOperation.SQRT.name(),
                new SqrtStrategy());
        strategies.put(MathOperation.UNDO.name(),
                new UndoStrategy());
        strategies.put(MathOperation.CLEAR.name(),
                new ClearStrategy());
    }


    public static OperationStrategy getInstance(String type) {
        return strategies.get(type);
    }
}
