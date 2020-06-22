package by.zercomp.basketAndBall.service;

import by.zercomp.basketAndBall.entity.Ball;
import by.zercomp.basketAndBall.entity.Basket;
import by.zercomp.basketAndBall.entity.Color;
import by.zercomp.basketAndBall.exception.BasketOverflowException;
import by.zercomp.basketAndBall.exception.InvalidDataException;
import by.zercomp.basketAndBall.validator.ArithmeticValidator;
import by.zercomp.basketAndBall.validator.BasketSpaceValidator;

import java.util.ArrayList;
import java.util.List;

public class BasketProcessor {

    private BasketProcessor() {
    }

    public static final int ABSOLUTE_ZERO = 0;

    public static Basket createBasket(int maxCapacity) throws InvalidDataException {
        if (ArithmeticValidator.isNegative(maxCapacity)) {
            throw new InvalidDataException("capacity must be positive number:" + maxCapacity);
        }
        return new Basket(maxCapacity);
    }

    public static void add(Ball ball, Basket basket) throws InvalidDataException, BasketOverflowException {
        if (ball == null) {
            throw new InvalidDataException("ball is null");
        }
        if (basket.getCounter() == basket.getMaxCapacity()) {
            throw new BasketOverflowException(basket.getMaxCapacity());
        }
        basket.getStorage().add(ball);
        addWeight(basket, ball.getWeight());
        basket.setCounter(Basket.getCounter() + 1);
    }

    public static Ball getByID(int id, Basket basket) throws InvalidDataException {
        if(BasketSpaceValidator.validateID(basket, id)) {
            basket.setCounter(basket.getCounter() + 1);
            Ball tempBall = basket.getStorage().remove(id);
            subtractWeight(basket, tempBall.getWeight());
            return tempBall;
        }
        throw new InvalidDataException("invalid id: " + id);
    }

    public static List<Ball> getByColor(Color color, Basket basket) throws InvalidDataException {
        if(color == null) {
            throw new InvalidDataException("color must be not null");
        }
        List<Ball> buffer = new ArrayList<Ball>();
        List<Ball> storage = basket.getStorage();
        for (Ball item: storage) {
            if(item != null && item.getColor().equals(color)) {
                Ball temp = item;
                //очистка из корзины
                storage.remove(temp);
                //добавление в буферный список.
                buffer.add(temp);
            }
        }
        return buffer;
    }

    private static void addWeight(Basket basket, double weight) throws InvalidDataException {
        if (ArithmeticValidator.isNegative(weight)) {
            throw new InvalidDataException("weight is negative: " + weight);
        }
        basket.setTotalWeight(basket.getTotalWeight() + weight);
    }

    private static void subtractWeight(Basket basket, double weight) throws InvalidDataException {
        if (ArithmeticValidator.isNegative(weight)) {
            throw new InvalidDataException("weight is negative: " + weight);
        }
        basket.setTotalWeight(basket.getTotalWeight() - weight);
    }

    public static Basket clear(Basket basket) {
        return new Basket(basket.getMaxCapacity());
    }
}
