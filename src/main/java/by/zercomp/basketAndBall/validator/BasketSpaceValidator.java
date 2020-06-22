package by.zercomp.basketAndBall.validator;

import by.zercomp.basketAndBall.entity.Basket;

public class BasketSpaceValidator {

    private BasketSpaceValidator() {
    }

    public static boolean validateID(Basket basket, int id) {
        final int capacity = basket.getMaxCapacity();
        return isInRange(-1, capacity, id);
    }

    private static boolean isInRange(int startIndex, int endIndex, int value) {
        return value > startIndex && value < endIndex;
    }
}
