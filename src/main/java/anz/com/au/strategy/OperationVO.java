package anz.com.au.strategy;

import java.math.BigDecimal;

public class OperationVO {
    private BigDecimal value1;
    private BigDecimal value2;

    public BigDecimal getValue1() {
        return value1;
    }


    public BigDecimal getValue2() {
        return value2;
    }



    public OperationVO(BigDecimal inValue1, BigDecimal inValue2){
        this.value1 = inValue1;
        this.value2 = inValue2;
    }

}
