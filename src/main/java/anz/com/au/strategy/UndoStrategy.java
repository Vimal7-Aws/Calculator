package anz.com.au.strategy;

import anz.com.au.operations.OperationUnit;
import org.apache.commons.collections4.CollectionUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class UndoStrategy implements OperationStrategy {
    public BigDecimal execute(OperationVO inOperationVO) {


        inOperationVO.getNumberStack().pop();
        if (CollectionUtils.isNotEmpty(inOperationVO.getOperationList()) ) {
            OperationUnit operationUnit2 = inOperationVO.getOperationList().pop();
            List<BigDecimal> list = operationUnit2.getOperands().stream().collect(Collectors.toList());
            //Collections.reverse(list);
            list.stream().forEach(numeral -> {
                inOperationVO.getNumberStack().push(numeral);
            });
        }
        return null;
    }
}
