package anz.com.au;

import java.util.Scanner;
import anz.com.au.manager.RpnManager;
import anz.com.au.operations.RpnConstants;
import anz.com.au.service.RpnService;
import anz.com.au.service.RpnServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public final class RpnCalculator {

    private static final Logger LOGGER = LoggerFactory.getLogger(RpnCalculator.class);

    private RpnCalculator() {
    }

    public static void main(String[] args) {

        RpnManager rpnManager = new RpnManager();
        RpnService rpnService = new RpnServiceImpl(rpnManager);
        LOGGER.info("---------------------------------------------");
        LOGGER.info("Enter  to exit of application");

        Scanner scan = new Scanner(System.in);
        String inValue = null;
        RpnCalculator rpnCalculator = new RpnCalculator();
        while (!RpnConstants.EXIT.equalsIgnoreCase(inValue)) {
            inValue = scan.nextLine();
            rpnService.calculate(inValue);
        }

    }
}
