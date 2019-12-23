package com.bruse.basic.util.random;

import java.util.Arrays;
import java.util.Random;

public class WeightRandom {

    private Pair[] options;

    private double[] cumulativeProbabilities;

    private Random random;

    public WeightRandom(Pair[] options) {
        this.options = options;
        this.random = new Random();
        this.prepare();
    }

    private void prepare() {
        int weights = 0;
        for (Pair pair : options) {
            weights += pair.getWeight();
        }
        cumulativeProbabilities = new double[options.length];
        int sum = 0;
        for (int i = 0; i < options.length; i++) {
            sum += options[i].getWeight();
            cumulativeProbabilities[i] = sum / (double) weights;
        }
    }

    public Object nextItem() {
        double randomValue = random.nextDouble();
        int index = Arrays.binarySearch(cumulativeProbabilities, randomValue);
        if (index < 0) {
            index = - index - 1;
        }
        return options[index].getItem();
    }

    public static void main(String[] args) {
        Pair[] options = new Pair[]{new Pair(" 1 元", 7), new Pair(" 2 元", 2), new Pair(" 10 元", 1)};
        WeightRandom rnd = new WeightRandom(options);
        for (int i = 0; i < 10; i++) {
            System.out.print(rnd.nextItem() + " ");
        }
    }
}

class Pair {

    private Object item;

    private int weight;

    public Pair(Object item, int weight) {
        this.item = item;
        this.weight = weight;
    }

    public Object getItem() {
        return item;
    }

    public int getWeight() {
        return weight;
    }
}