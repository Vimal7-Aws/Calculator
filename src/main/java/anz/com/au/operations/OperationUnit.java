package anz.com.au.operations;

import java.math.BigDecimal;
import java.util.Stack;

public class OperationUnit {

    private Stack<BigDecimal> operands;
    private MathOperation operation;

    public OperationUnit() {
        operands = new Stack<>();
    }


    public Stack<BigDecimal> getOperands() {
        return operands;
    }





}
