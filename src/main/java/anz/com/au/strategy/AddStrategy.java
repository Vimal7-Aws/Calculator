package anz.com.au.strategy;

import anz.com.au.manager.RpnOperationsBase;

import java.math.BigDecimal;

public class AddStrategy implements OperationBaseStrategy {
    public void execute(OperationVO inOperationVO) {

        RpnOperationsBase.arrange(inOperationVO, false);
        BigDecimal value = inOperationVO.getNumberStack().pop().add(inOperationVO.getNumberStack().pop());
        inOperationVO.getNumberStack().push(value);

    }
}
