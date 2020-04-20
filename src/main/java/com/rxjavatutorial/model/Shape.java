package com.rxjavatutorial.model;

/**
 * Created by Mayur Solanki (mayursolanki120@gmail.com) on 20/04/20, 6:52 PM.
 */
public class Shape {

    String color;
    String shape;

    public Shape(String color, String shape) {
        this.color = color;
        this.shape = shape;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "shape='" + shape + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

}
