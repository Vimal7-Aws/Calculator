package anz.com.au.strategy;

import java.math.BigDecimal;

public class MultiplyStrategy implements OperationStrategy {
    public BigDecimal execute(OperationVO operationVO) {

        return operationVO.getValue1().multiply(operationVO.getValue2());
    }
}
