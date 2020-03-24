package com.bruse.patterns.factory.abstract_;

public class M4Factory implements Factory {
    @Override
    public Gun getGun() {
        return new M4();
    }

    @Override
    public Bullet getBullet() {
        return new M4Bullet();
    }
}
