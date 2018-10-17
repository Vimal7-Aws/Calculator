package anz.com.au.strategy;

import java.math.BigDecimal;

public class AddStrategy implements OperationStrategy {
    public BigDecimal execute(OperationVO inOperationVO) {

        return inOperationVO.getValue1().add(inOperationVO.getValue2());
    }
}
