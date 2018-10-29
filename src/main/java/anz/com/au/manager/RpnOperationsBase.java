package anz.com.au.manager;

import anz.com.au.operations.OperationUnit;
import anz.com.au.strategy.OperationVO;

import java.math.BigDecimal;
import java.util.Stack;

public class RpnOperationsBase {

    public static void arrange(OperationVO inOperationVO, boolean isSqrt) {
        BigDecimal operand1 = inOperationVO.getNumberStack().get(0);
        BigDecimal operand2 = getNextOperand(isSqrt, inOperationVO.getNumberStack());
        OperationUnit operationUnit = new OperationUnit();
        operationUnit.getOperands().push(operand1);
        operationUnit.getOperands().push(operand2);
        inOperationVO.getOperationList().push(operationUnit);

    }

    private static BigDecimal getNextOperand(boolean isSqrt, Stack<BigDecimal> numberStack) {
        return isSqrt ? BigDecimal.ONE : numberStack.get(1) ;
    }

}
