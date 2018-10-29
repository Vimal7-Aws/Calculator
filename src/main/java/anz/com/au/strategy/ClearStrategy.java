package anz.com.au.strategy;

import java.math.BigDecimal;

public class ClearStrategy implements OperationStrategy {
    public BigDecimal execute(OperationVO inOperationVO) {
        inOperationVO.getNumberStack().clear();
        return null;
    }
}
