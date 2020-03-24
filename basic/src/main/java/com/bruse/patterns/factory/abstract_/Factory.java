package com.bruse.patterns.factory.abstract_;

/**
 * 抽象工厂模式
 */
public interface Factory {
    Gun getGun();

    Bullet getBullet();

    public static void main(String[] args) {
        Factory factory = new AKFactory();
        Gun gun = factory.getGun();
        Bullet bullet = factory.getBullet();
        bullet.load();
        gun.shooting();
    }
}
