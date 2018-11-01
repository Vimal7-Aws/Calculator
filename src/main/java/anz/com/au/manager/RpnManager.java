package anz.com.au.manager;

import anz.com.au.exception.InSufficientParameterException;
import anz.com.au.operations.MathOperation;
import anz.com.au.operations.OperationUnit;
import anz.com.au.strategy.OperationBaseStrategy;
import anz.com.au.strategy.OperationVO;
import anz.com.au.strategy.StrategyFactory;
import anz.com.au.utils.RpnUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class RpnManager extends RpnOperationsBase {
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
                validateSufficientParameters(inValue);
                if (!numberStack.isEmpty()) {
                    doOperation(inValue);
                }
            }
            logger.info("The stack after calculation is :==> {}" , numberStack);
        });
        return numberStack;
    }

    private void validateSufficientParameters(String inValue) {
        if (numberStack.size() == 1 &&
                !(inValue.equalsIgnoreCase(MathOperation.CLEAR.name()) ||
                        inValue.equalsIgnoreCase(MathOperation.SQRT.name()) ||
                        inValue.equalsIgnoreCase("undo"))) {
            throw new InSufficientParameterException("Insufficient Parameters");
        }
    }


    private void doOperation(String inValue) {

        OperationBaseStrategy strategy = StrategyFactory.getInstance(MathOperation.getOperation(inValue));
        OperationVO operationVO = new OperationVO(numberStack, operationList);
        strategy.execute(operationVO);

        logger.info("value after execution {} ", operationVO.getNumberStack());
    }


}
