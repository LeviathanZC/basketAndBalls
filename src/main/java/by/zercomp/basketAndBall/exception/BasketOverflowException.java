package by.zercomp.basketAndBall.exception;

public class BasketOverflowException extends Exception {

    private static final String startMsg = "Basket is full. ";

    public BasketOverflowException(int capacity) {
        super(new StringBuilder(startMsg).append("max capacity:").append(capacity).toString());
    }


}
