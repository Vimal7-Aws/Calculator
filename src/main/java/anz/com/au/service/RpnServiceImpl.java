package anz.com.au.service;

import anz.com.au.manager.RpnManager;

import java.math.BigDecimal;
import java.util.Stack;


/**
 *
 *
 *
 */
public class RpnServiceImpl implements RpnService {

    private RpnManager rpnManager;

    public RpnServiceImpl(RpnManager inRpnManager) {
        this.rpnManager = inRpnManager;
    }

    public Stack<BigDecimal> calculate(String inValue) {
        return rpnManager.calculate(inValue);
    }
}
