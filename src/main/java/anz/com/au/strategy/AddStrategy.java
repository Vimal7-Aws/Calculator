package anz.com.au.strategy;

import anz.com.au.manager.RpnOperationsBase;

import java.math.BigDecimal;

public class AddStrategy implements OperationStrategy {
    public BigDecimal execute(OperationVO inOperationVO) {

        RpnOperationsBase.arrange(inOperationVO, false);
        return inOperationVO.getNumberStack().pop().add(inOperationVO.getNumberStack().pop());
    }
}
