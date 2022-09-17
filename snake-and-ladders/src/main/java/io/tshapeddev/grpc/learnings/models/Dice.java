package io.tshapeddev.grpc.learnings.models;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {

    private int top = 1;

    public int roll() {
        top = ThreadLocalRandom.current().nextInt(1, 7);
        return top;
    }

    public int getTop() {
        return top;
    }
}
