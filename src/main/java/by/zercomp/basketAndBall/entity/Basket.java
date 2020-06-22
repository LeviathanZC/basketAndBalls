package by.zercomp.basketAndBall.entity;

import by.zercomp.basketAndBall.exception.BasketOverflowException;
import by.zercomp.basketAndBall.exception.InvalidDataException;
import by.zercomp.basketAndBall.validator.ArithmeticValidator;
import by.zercomp.basketAndBall.validator.BasketSpaceValidator;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    private static int counter = 0;

    private double totalWeight;
    private int maxCapacity;
    private List<Ball> storage;

    public Basket(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.storage = new ArrayList<Ball>();
        this.totalWeight = 0;
    }

    public void add(Ball ball) throws InvalidDataException, BasketOverflowException {
        if(ball == null) {
            throw new InvalidDataException("ball is null");
        }
        if (counter == maxCapacity) {
            throw new BasketOverflowException(maxCapacity);
        }
        this.storage.add(ball);
        addWeight(ball.getWeight());
        counter++;
    }

    public Ball getByID(int id) throws InvalidDataException {
        if(BasketSpaceValidator.validateID(this, id)) {
            counter--;
            Ball tempBall = storage.remove(id);
            subtractWeight(tempBall.getWeight());
            return tempBall;
        }
        throw new InvalidDataException("invalid id: " + id);
    }

    public List<Ball> getByColor(Color color) throws InvalidDataException {
        if(color == null) {
            throw new InvalidDataException("color must be not null");
        }
        List<Ball> buffer = new ArrayList<Ball>();
        for (Ball item: this.storage) {
            if(item != null && item.getColor().equals(color)) {
                buffer.add(item);
            }
        }
        return buffer;
    }

    private void addWeight(double weight) throws InvalidDataException {
        if(ArithmeticValidator.isNegative(weight)) {
            throw new InvalidDataException("weight is negative: " + weight);
        }
        this.totalWeight += weight;
    }

    private void subtractWeight(double weight) throws InvalidDataException {
        if(ArithmeticValidator.isNegative(weight)) {
            throw new InvalidDataException("weight is negative: " + weight);
        }
        this.totalWeight -= weight;
    }

    public void clear() {
        counter = 0;
        this.storage = new ArrayList<Ball>();
        this.totalWeight = 0;
    }

    public boolean isFull() {
        return counter == maxCapacity;
    }

    public boolean isEmpty() {
        return counter == 0;
    }


    public static int getCounter() {
        return counter;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public List<Ball> getStorage() {
        return storage;
    }

    public void setStorage(List<Ball> storage) {
        this.storage = storage;
    }
}
