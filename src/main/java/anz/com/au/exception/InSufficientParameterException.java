package anz.com.au.exception;

public class InSufficientParameterException extends RuntimeException {

    public InSufficientParameterException(Exception exc) {
        super(exc);
    }

    public InSufficientParameterException(String message) {
        super(message);
    }



}
