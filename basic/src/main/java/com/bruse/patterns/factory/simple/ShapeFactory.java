package com.bruse.patterns.factory.simple;

/**
 * 简单工厂模式
 */
public class ShapeFactory {

    public static Shape getShape(Class<? extends Shape> clazz) {
        try {
            return clazz.newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        Shape circle = ShapeFactory.getShape(Circle.class);
        Shape square = ShapeFactory.getShape(Square.class);
        circle.draw();
        square.draw();
    }
}
