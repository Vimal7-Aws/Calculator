package anz.com.au.strategy;

import anz.com.au.manager.RpnOperationsBase;

import java.math.BigDecimal;

public class MultiplyStrategy implements OperationStrategy {
    public BigDecimal execute(OperationVO operationVO) {
        RpnOperationsBase.arrange(operationVO, false);

        BigDecimal value1 = operationVO.getNumberStack().pop();
        BigDecimal value2 = operationVO.getNumberStack().pop();
        return value1.multiply(value2);
    }
}
