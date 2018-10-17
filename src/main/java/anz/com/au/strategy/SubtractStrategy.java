package anz.com.au.strategy;

import java.math.BigDecimal;

public class SubtractStrategy implements OperationStrategy {
    public BigDecimal execute(OperationVO operationVO) {

        return operationVO.getValue2().subtract(operationVO.getValue1());
    }
}
