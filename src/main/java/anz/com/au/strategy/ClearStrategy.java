package anz.com.au.strategy;

import java.math.BigDecimal;

public class ClearStrategy implements OperationBaseStrategy {
    public void execute(OperationVO inOperationVO) {
        inOperationVO.getNumberStack().clear();
    }
}
