package com.bruse.patterns.factory.method;

import com.bruse.patterns.factory.simple.Shape;
import com.bruse.patterns.factory.simple.Square;

public class SquareFactory implements Factory {
    @Override
    public Shape getShape() {
        return new Square();
    }
}
