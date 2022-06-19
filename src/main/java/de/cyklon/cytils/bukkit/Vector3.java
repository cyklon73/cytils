package de.cyklon.cytils.bukkit;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.util.BlockVector;
import org.bukkit.util.NumberConversions;
import org.bukkit.util.Vector;

import java.util.ArrayList;

public class Vector3 {

    public double x;
    public double y;
    public double z;

    public Vector3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return x + "," + y + "," + z;
    }

    public static Vector3 parseVector3(String s) {
        String[] c = s.split(",");
        return new Vector3(Float.parseFloat(c[0]), Float.parseFloat(c[1]), Float.parseFloat(c[2]));
    }

    public static Vector3 parseVector3(String s1, String s2, String s3) {
        return new Vector3(Float.parseFloat(s1), Float.parseFloat(s2), Float.parseFloat(s3));
    }

    public static Vector3 parseVector3(Vector vec) {
        return new Vector3(vec.getX(), vec.getY(), vec.getZ());
    }

    public static Vector3 parseVector3(Location loc) {
        return new Vector3(loc.getX(), loc.getY(), loc.getZ());
    }

    public static Vector3 parseVector3(String[] s) {
        return new Vector3(Float.parseFloat(s[0]), Float.parseFloat(s[1]), Float.parseFloat(s[2]));
    }

    public static Vector3 parseVector3(Float[] s) {
        return new Vector3(s[0], s[1], s[2]);
    }

    public static Vector3 parseVector3(Integer[] s) {
        return new Vector3(s[0], s[1], s[2]);
    }

    public Vector toVector() {
        return new Vector(x, y, z);
    }

    public Location toLocation(World world) {
        return new Location(world, x ,y, z);
    }

    public Location toLocation(World world, float yaw, float pitch) {
        return new Location(world, x, y, z, yaw, pitch);
    }

    public BlockVector toBlockVector() {
        return new BlockVector(x, y, z);
    }

    public Vector3 subtract(Vector3 vec) {
        x -= vec.x;
        y -= vec.y;
        z -= vec.z;
        return this;
    }

    public Vector3 times(double n) {
        x *= n;
        y *= n;
        z *= n;
        return this;
    }


    public Vector3 cross(Vector3 vec) {
        return new Vector3(y*vec.z-z*vec.y, z*vec.x-x*vec.z, x*vec.y-y*vec.x);
    }

    public Vector3 round() {
        return new Vector3(Math.round(x), Math.round(y), Math.round(z));
    }

    public double scalar(Vector3 vec) {
        return x*vec.x+y*vec.y+z*vec.z;
    }

    public double angle(Vector3 vec) {
        return Math.acos(clone().normalize().scalar(vec.clone().normalize()));
    }

    public Vector3 normalize() {
        double length = length();
        x /= length;
        y /= length;
        z /= length;
        return this;
    }

    public ArrayList<Double> toArrayList() {
        ArrayList<Double> a = new ArrayList<>();
        a.add(x);
        a.add(y);
        a.add(z);
        return a;
    }

    public void add (Vector3 v) {
        x += v.x;
        y += v.y;
        z += v.z;
    }

    @Override
    public Vector3 clone () {
        return new Vector3(x, y, z);
    }

    public Vector3 copy(Vector3 v) {
        x = v.x;
        y = v.y;
        z = v.z;
        return this;
    }

    public double getX() {
        return x;
    }

    public int getBlockX() {
        return NumberConversions.floor(x);
    }

    public double getY() {
        return y;
    }

    public int getBlockY() {
        return NumberConversions.floor(y);
    }

    public double getZ() {
        return z;
    }

    public int getBlockZ() {
        return NumberConversions.floor(z);
    }

    public Vector3 setX(int x) {
        this.x = x;
        return this;
    }

    public Vector3 setX(double x) {
        this.x = (float) x;
        return this;
    }

    public Vector3 setX(float x) {
        this.x = x;
        return this;
    }

    public Vector3 setY(int y) {
        this.y = y;
        return this;
    }

    public Vector3 setY(double y) {
        this.y = (float) y;
        return this;
    }

    public Vector3 setY(float y) {
        this.y = y;
        return this;
    }

    public Vector3 setZ(int z) {
        this.z = z;
        return this;
    }

    public Vector3 setZ(double z) {
        this.z = (float) z;
        return this;
    }

    public Vector3 setZ(float z) {
        this.z = z;
        return this;
    }

    public double length() {
        return Math.sqrt(NumberConversions.square(x) + NumberConversions.square(y) + NumberConversions.square(z));
    }
}

