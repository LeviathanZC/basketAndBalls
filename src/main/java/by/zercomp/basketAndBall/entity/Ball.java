package by.zercomp.basketAndBall.entity;

public class Ball {

    private double weight;
    private Color color;

    public Ball(double weight, Color color) {
        this.weight = weight;
        this.color = color;
    }

    public double getWeight() {
        return this.weight;
    }

    public Color getColor() {
        return this.color;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}
