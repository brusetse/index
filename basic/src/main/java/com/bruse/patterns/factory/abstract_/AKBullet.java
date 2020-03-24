package com.bruse.patterns.factory.abstract_;

public class AKBullet implements Bullet {
    @Override
    public void load() {
        System.out.println("Load bullets with AK");
    }
}
