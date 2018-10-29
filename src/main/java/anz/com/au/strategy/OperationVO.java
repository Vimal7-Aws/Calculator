package anz.com.au.strategy;

import anz.com.au.operations.OperationUnit;

import java.math.BigDecimal;
import java.util.Stack;

public class OperationVO {
    private Stack<BigDecimal> numberStack;

    public Stack<BigDecimal> getNumberStack() {
        return numberStack;
    }

    public Stack<OperationUnit> getOperationList() {
        return operationList;
    }

    private Stack<OperationUnit> operationList;


    public OperationVO(Stack<BigDecimal> numberStack, Stack<OperationUnit> operationList) {
        this.numberStack = numberStack;
        this.operationList = operationList;
    }
}
