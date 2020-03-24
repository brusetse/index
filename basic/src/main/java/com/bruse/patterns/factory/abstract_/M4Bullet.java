package com.bruse.patterns.factory.abstract_;

public class M4Bullet implements Bullet {
    @Override
    public void load() {
        System.out.println("Load bullets with M4");
    }
}
