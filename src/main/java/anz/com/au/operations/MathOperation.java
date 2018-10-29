package anz.com.au.operations;

import java.util.HashMap;
import java.util.Map;

public enum MathOperation {


    ADD("+"),
    MULTIPLY("*"),
    SUBTRACT("-"),
    DIVIDE("/"),
    CLEAR("clear"),
    UNDO("undo"),
    SQRT("sqrt");


    private static Map<String, String> oparationsMap;
    private String value;


    MathOperation(String value) {
        this.value = value;
    }


    public String getValue() {
        return value;
    }



    public static String getOperation(String symbol) {
        if (oparationsMap == null) {
            initializeMapping();
        }
        if (oparationsMap.containsKey(symbol)) {
            return oparationsMap.get(symbol);
        }
        return null;
    }

    private static void initializeMapping() {
        oparationsMap = new HashMap<>();
        for (MathOperation ops : MathOperation.values()) {
            oparationsMap.put(ops.value, ops.name());
        }
    }

}
