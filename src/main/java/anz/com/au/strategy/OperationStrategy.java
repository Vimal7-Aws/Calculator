package anz.com.au.strategy;

import java.math.BigDecimal;

public interface OperationStrategy {
    BigDecimal execute(OperationVO operationVO);
}
