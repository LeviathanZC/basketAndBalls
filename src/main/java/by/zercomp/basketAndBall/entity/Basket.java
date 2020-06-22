package by.zercomp.basketAndBall.entity;

public class Basket {

    private double totalWeight;
    private int capacity;
    private Ball[] storage;


    public Basket(int capacity) {
        this.capacity = capacity;
        this.storage = new Ball[capacity];
    }

    public add(Ball ball) {
        if(ball == null) {

        }
    }
}
