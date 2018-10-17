package anz.com.au.service;


import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Stack;

@Service
public interface RpnService {
    Stack<BigDecimal> calculate(String inValue);
}
