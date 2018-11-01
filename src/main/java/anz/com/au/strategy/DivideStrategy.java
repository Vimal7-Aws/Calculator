package anz.com.au.strategy;

import anz.com.au.manager.RpnOperationsBase;

import java.math.BigDecimal;

public class DivideStrategy implements OperationBaseStrategy {
    public void execute(OperationVO operationVO) {
        RpnOperationsBase.arrange(operationVO, false);

        BigDecimal value1 = operationVO.getNumberStack().pop();
        BigDecimal value2 = operationVO.getNumberStack().pop();
        BigDecimal value = value2.divide(value1);
        operationVO.getNumberStack().push(value);
    }
}
