package anz.com.au.strategy;

import java.math.BigDecimal;

public class DivideStrategy implements OperationStrategy {
    public BigDecimal execute(OperationVO operationVO) {

        return operationVO.getValue2().divide(operationVO.getValue1());
    }
}
