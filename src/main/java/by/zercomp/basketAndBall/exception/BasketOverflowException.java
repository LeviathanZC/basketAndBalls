package by.zercomp.basketAndBall.exception;

public class BasketOverflowException extends Exception {

    private static final String message = "Basket is full: ";

    public BasketOverflowException(double weightConstraint, double weight) {
        super(new StringBuilder(message).append(weightConstraint).append(" ,").append(weight).toString());
    }

}
