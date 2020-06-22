package by.zercomp.basketAndBall.entity;

public enum Color {


    RED("Red"), ORANGE("Orange"), YELLOW("Yellow"),
    GREEN("Green"), BLUE("Blue"), PURPLE("Purple");

    private String colorName;

    Color(String color) {
        this.colorName = color;
    }

    @Override
    public String toString() {
        return new StringBuilder("Color {\n").append("\tcolor:").append(this.colorName).append("\n}").toString();
    }
}
