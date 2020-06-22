package by.zercomp.basketAndBall.entity;

import by.zercomp.basketAndBall.exception.BasketOverflowException;
import by.zercomp.basketAndBall.exception.InvalidDataException;

public class Basket {

    private static int counter = 0;

    private double totalWeight;
    private int maxCapacity;
    private Ball[] storage;



    public Basket(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.storage = new Ball[maxCapacity];
    }

    public void add(Ball ball) throws InvalidDataException, BasketOverflowException {
        if(ball == null) {
            throw new InvalidDataException("ball is null");
        }
        if (counter == maxCapacity) {
            throw new BasketOverflowException(maxCapacity);
        }
        this.storage[counter++] = ball;
    }

    public void getByID(int id) {

    }

    public void clear() {
        counter = 0;
        this.storage = new Ball[maxCapacity];
    }

    public boolean isFull() {
        return counter == maxCapacity;
    }

    public boolean isEmpty() {
        return counter == 0;
    }
}
