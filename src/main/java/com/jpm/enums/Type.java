package com.jpm.enums;

import java.util.Random;

public enum Type {

    SELL("S"), BUY("B");

    private String type;

    Type(String type){
        this.type = type;
    }

    public static Type getRandomType() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }

    public static Type fromString(String type) {
        for (Type b : Type.values()) {
            if (b.type.equalsIgnoreCase(type)) {
                return b;
            }
        }
        return null;
    }

}
