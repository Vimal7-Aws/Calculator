package anz.com.au.utils;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;
import static org.apache.commons.lang3.StringUtils.SPACE;
import static org.apache.commons.lang3.StringUtils.split;

public class RpnUtils {

    public static final int SCALE = 15;

    private RpnUtils() {

    }

    public static List<String> getString(String inExpression) {

        List<String> expression = Arrays.stream(split(inExpression.trim(), StringUtils.SPACE))
                .collect(Collectors.toList());
        return expression;
    }



    private static Function<BigDecimal, String> displayScale =
            decimal -> decimal.setScale(10, RoundingMode.DOWN).stripTrailingZeros().toPlainString();



    public static String displayState(Stack<BigDecimal> numberStack) {
        return numberStack
                .stream()
                .map(displayScale)
                .collect(joining(SPACE));
    }

}
