package com.bruse.patterns.factory.method;

import com.bruse.patterns.factory.simple.Circle;
import com.bruse.patterns.factory.simple.Shape;

public class CircleFactory implements Factory {
    @Override
    public Shape getShape() {
        return new Circle();
    }
}
