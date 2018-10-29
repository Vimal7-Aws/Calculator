package anz.com.au.strategy;

import anz.com.au.manager.RpnOperationsBase;

import java.math.BigDecimal;

public class SqrtStrategy implements OperationStrategy {
    public BigDecimal execute(OperationVO operationVO) {
        RpnOperationsBase.arrange(operationVO, true);

        BigDecimal value1 = operationVO.getNumberStack().pop();
        BigDecimal sqrtValue = new BigDecimal((Math.sqrt(value1.doubleValue())));

        return sqrtValue;
    }
}
