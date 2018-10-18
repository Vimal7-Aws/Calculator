package anz.com.au.service;


import java.math.BigDecimal;
import java.util.Stack;

import org.springframework.stereotype.Service;

@Service
public interface RpnService {
    Stack<BigDecimal> calculate(String inValue);
}
