package com.github.cyklon73.cytils;

import java.security.SecureRandom;
import java.util.Date;

public class Random {

    public static int randInt(int min, int max) {
        SecureRandom rand = new SecureRandom();
        rand.setSeed(new Date().getTime());
        return rand.nextInt((max - min) + 1) + min;
    }

    public static Boolean percentChance(double chance) {
        return java.lang.Math.random() <= chance;
    }
}
