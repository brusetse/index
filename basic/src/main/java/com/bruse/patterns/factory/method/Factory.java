package com.bruse.patterns.factory.method;

import com.bruse.patterns.factory.simple.Shape;

/**
 * 工厂方法模式
 */
public interface Factory {
    Shape getShape();

    public static void main(String[] args) {
        Factory circleFactory = new CircleFactory();
        Shape shape = circleFactory.getShape();
        shape.draw();
    }
}
