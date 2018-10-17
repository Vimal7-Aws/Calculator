package anz.com.au.service;

import anz.com.au.exception.InSufficientParameterException;
import anz.com.au.utils.RpnUtils;
import anz.com.au.manager.RpnManager;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class RpnServiceTest {

    RpnService rpnService;
    RpnManager rpnManager;
    @Before
    public void init() {
        rpnManager = new RpnManager();
        rpnService = new RpnServiceImpl(rpnManager);
    }


    @Test
    public void calculate_expression_1() {

        Stack<BigDecimal> calculate = rpnService.calculate("5 2");
        System.out.println(calculate);
       assertEquals("", "5 2" , RpnUtils.displayState(calculate));
    }



    @Test
    public void calculate_expression_2() {
        Stack<BigDecimal> calculate = rpnService.calculate("5 2 -");
        assertEquals("3", "3", RpnUtils.displayState(calculate));


        calculate = rpnService.calculate("3 -");
        assertEquals("0", "0", RpnUtils.displayState(calculate));


        calculate = rpnService.calculate("clear");
        assertEquals("", "", RpnUtils.displayState(calculate));
    }



    @Test
    public void calculate_expression_3() {

        Stack<BigDecimal> calculate = rpnService.calculate("5 4 3 2");

        assertEquals(
                "5 4 3 2",
                "5 4 3 2",
                RpnUtils.displayState(calculate));

        calculate = rpnService.calculate("undo undo *");
        assertEquals("20", "20", RpnUtils.displayState(calculate));
        calculate = rpnService.calculate("5 *");
        assertEquals("100", "100", RpnUtils.displayState(calculate));
        calculate = rpnService.calculate("undo");
        assertEquals("20 5", "20 5", RpnUtils.displayState(calculate));

    }



    @Test
    public void calculate_expression_4() {

        Stack<BigDecimal> calculate = rpnService.calculate("7 12 2 /");

        assertEquals("7 6", "7 6", RpnUtils.displayState(calculate));

        calculate = rpnService.calculate("*");
        assertEquals("42", "42", RpnUtils.displayState(calculate));

        calculate = rpnService.calculate("4 /");

        assertEquals("10.5", "10.5", RpnUtils.displayState(calculate));
    }




    @Test
    public void calculate_expression_5() {

        Stack<BigDecimal> calculate = rpnService.calculate("1 2 3 4 5");

        assertEquals(
                "1 2 3 4 5", "1 2 3 4 5", RpnUtils.displayState(calculate));

        calculate = rpnService.calculate("*");


        assertEquals("1 2 3 20", "1 2 3 20", RpnUtils.displayState(calculate));

        calculate = rpnService.calculate("clear 3 4 -");

        assertEquals("-1", "-1", RpnUtils.displayState(calculate));
    }



    @Test
    public void calculate_expression_6() {
        Stack<BigDecimal> calculate = rpnService.calculate("1 2 3 4 5");

        assertEquals(
                "1 2 3 4 5", "1 2 3 4 5", RpnUtils.displayState(calculate));

        calculate = rpnService.calculate("* * * *");

        assertEquals("120", "120",  RpnUtils.displayState(calculate));
    }

    @Test(expected = InSufficientParameterException.class)
    public void calculate_expression_7() {
        Stack<BigDecimal> calculate = rpnService.calculate("1 2 3 * 5 + * * 6 5");
        assertEquals(
                "11", "11", RpnUtils.displayState(calculate));

    }



    @Test
    public void calculate_expression_8() {
        Stack<BigDecimal> calculate = rpnService.calculate("2 sqrt");
        assertEquals(
                "1.4142135623",
                "1.4142135623",
                RpnUtils.displayState(calculate));
    }


}
