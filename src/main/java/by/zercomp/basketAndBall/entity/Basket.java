package by.zercomp.basketAndBall.entity;


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

    public static void setCounter(int counter) {
        Basket.counter = counter;
    }

    public void setTotalWeight(double totalWeight) {
        this.totalWeight = totalWeight;
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
