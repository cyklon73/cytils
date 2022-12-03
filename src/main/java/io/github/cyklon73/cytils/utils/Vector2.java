package io.github.cyklon73.cytils.utils;


import org.bukkit.util.NumberConversions;

import java.awt.*;
import java.util.ArrayList;

public class Vector2 {

    private double x;
    private double y;

    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return x + "," + y;
    }

    public Dimension toDimension() {
        return new Dimension((int) x, (int) y);
    }
    public static Vector2 parseVector2(String s) {
        String[] c = s.split(",");
        return new Vector2(Float.parseFloat(c[0]), Float.parseFloat(c[1]));
    }

    public static Vector2 parseVector2(String s1, String s2, String s3) {
        return new Vector2(Float.parseFloat(s1), Float.parseFloat(s2));
    }

    public static Vector2 parseVector2(String[] s) {
        return new Vector2(Float.parseFloat(s[0]), Float.parseFloat(s[1]));
    }

    public static Vector2 parseVector2(Float[] s) {
        return new Vector2(s[0], s[1]);
    }

    public static Vector2 parseVector2(Integer[] s) {
        return new Vector2(s[0], s[1]);
    }

    public Vector2 subtract(Vector2 vec) {
        x -= vec.x;
        y -= vec.y;
        return this;
    }

    public Vector2 times(double n) {
        x *= n;
        y *= n;
        return this;
    }


    public Vector2 cross(Vector2 vec) {
        return new Vector2(y*vec.x-x*vec.y, y*vec.x-x*vec.y);
    }

    public double scalar(Vector2 vec) {
        return x*vec.x+y*vec.y+x*vec.x;
    }

    public double angle(Vector2 vec) {
        return Math.acos(clone().normalize().scalar(vec.clone().normalize()));
    }

    public Vector2 normalize() {
        double length = length();
        x /= length;
        y /= length;
        return this;
    }

    public ArrayList<Double> toArrayList() {
        ArrayList<Double> a = new ArrayList<>();
        a.add(x);
        a.add(y);
        return a;
    }

    public void add (Vector2 v) {
        x += v.x;
        y += v.y;
    }

    @Override
    public Vector2 clone () {
        return new Vector2(x, y);
    }

    public Vector2 copy(Vector2 v) {
        x = v.x;
        y = v.y;
        return this;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Vector2 setX(int x) {
        this.x = x;
        return this;
    }

    public Vector2 setX(double x) {
        this.x = (float) x;
        return this;
    }

    public Vector2 setX(float x) {
        this.x = x;
        return this;
    }

    public Vector2 setY(int y) {
        this.y = y;
        return this;
    }

    public Vector2 setY(double y) {
        this.y = (float) y;
        return this;
    }

    public Vector2 setY(float y) {
        this.y = y;
        return this;
    }


    public double length() {
        return Math.sqrt(NumberConversions.square(x) + NumberConversions.square(y));
    }
}

