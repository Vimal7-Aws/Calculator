package anz.com.au.strategy;

import java.math.BigDecimal;

public class SqrtStrategy implements OperationStrategy {
    public BigDecimal execute(OperationVO operationVO) {

        BigDecimal sqrtValue = new BigDecimal((Math.sqrt(operationVO.getValue1().doubleValue())));

        return sqrtValue;
    }
}
