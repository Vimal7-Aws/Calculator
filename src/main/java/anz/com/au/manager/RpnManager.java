package anz.com.au.manager;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

import anz.com.au.exception.InSufficientParameterException;
import anz.com.au.operations.MathOperation;
import anz.com.au.operations.OperationUnit;
import anz.com.au.utils.RpnUtils;
import anz.com.au.strategy.OperationStrategy;
import anz.com.au.strategy.OperationVO;
import anz.com.au.strategy.StrategyFactory;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RpnManager {
    private final Logger logger = LoggerFactory.getLogger(RpnManager.class);


    private Stack<BigDecimal> numberStack = new Stack();
    private Stack<OperationUnit> operationList = new Stack();


    public RpnManager() {

    }

    public Stack<BigDecimal> calculate(String inExpression) {

        List<String> tokens = RpnUtils.getString(inExpression);
        tokens.stream().forEach(inValue -> {
            if (NumberUtils.isParsable(inValue)) {
                numberStack.push(new BigDecimal(inValue));
            } else {
                validateSufficentParameters(inValue);
                boolean isSqrt = false;
                if (MathOperation.getOperation(inValue) == MathOperation.SQRT.name()) {
                    isSqrt = true;
                }
                if (MathOperation.getOperation(inValue) == MathOperation.CLEAR.name()) {
                    numberStack.clear();
                }
                if (!numberStack.isEmpty()) {
                    doOperation(inValue, isSqrt);
                }
            }
            logger.info("The stack after calculation is :==>" + numberStack);
        });
        return numberStack;
    }

    private void validateSufficentParameters(String inValue) {
        if (numberStack.size() == 1 &&
                !(inValue.equalsIgnoreCase(MathOperation.CLEAR.name()) ||
                        inValue.equalsIgnoreCase(MathOperation.SQRT.name()) ||
                        inValue.equalsIgnoreCase("undo"))) {
            throw new InSufficientParameterException("Insufficient Parameters");
        }
    }

    private void doUndo() {
        numberStack.pop();
        if (CollectionUtils.isNotEmpty(operationList)) {
            OperationUnit operationUnit2 = operationList.pop();
            List<BigDecimal> list = operationUnit2.getOperands().stream().collect(Collectors.toList());
            Collections.reverse(list);
            list.stream().forEach(numeral -> {
                numberStack.push(numeral);
            });
        }
    }

    private void doOperation(String inValue, boolean isSqrt) {
        if (inValue.equalsIgnoreCase("undo")) {
            doUndo();
        } else {
            BigDecimal operand1 = numberStack.pop();
            BigDecimal operand2;
            operand2 = getNextOperand(isSqrt);
            OperationUnit operationUnit = new OperationUnit();
            operationUnit.getOperands().push(operand1);
            operationUnit.getOperands().push(operand2);
            operationList.push(operationUnit);
            OperationStrategy strategy = StrategyFactory.getInstance(MathOperation.getOperation(inValue));
            OperationVO operationVO = new OperationVO(operand1, operand2);
            BigDecimal execute = strategy.execute(operationVO);
            numberStack.push(execute);
            System.out.println(execute);
        }
    }

    private BigDecimal getNextOperand(boolean isSqrt) {
        return isSqrt ? BigDecimal.ONE : numberStack.pop();
    }


}
