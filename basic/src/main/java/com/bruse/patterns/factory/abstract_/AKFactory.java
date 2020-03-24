package com.bruse.patterns.factory.abstract_;

public class AKFactory implements Factory {
    @Override
    public Gun getGun() {
        return new AK();
    }

    @Override
    public Bullet getBullet() {
        return new AKBullet();
    }
}
