package anz.com.au.strategy;

import anz.com.au.manager.RpnOperationsBase;

import java.math.BigDecimal;

public class SqrtStrategy implements OperationBaseStrategy {
    public void execute(OperationVO operationVO) {
        RpnOperationsBase.arrange(operationVO, true);

        BigDecimal value1 = operationVO.getNumberStack().pop();
        BigDecimal sqrtValue = new BigDecimal((Math.sqrt(value1.doubleValue())));
        operationVO.getNumberStack().push(sqrtValue);
    }
}
