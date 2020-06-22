package by.zercomp.basketAndBall.validator;

public class ArithmeticValidator {

    private ArithmeticValidator() {
    }

    private static final double ABSOLUTE_ZERO = 0.0;

    public static boolean isNegative(int number) {
        return number < ABSOLUTE_ZERO;
    }

    public static boolean isNegative(double number) {
        return number < ABSOLUTE_ZERO;
    }

    public static boolean isPositive(int number) {
        return number > ABSOLUTE_ZERO;
    }

    public static boolean isPositive(double number) {
        return number > ABSOLUTE_ZERO;
    }
}
