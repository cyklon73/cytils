package com.github.cyklon73.cytils.bukkit;

import org.bukkit.Material;
import org.bukkit.Rotation;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

public class Util {

    public static String rotationToString(Rotation rotation) {
        return switch (rotation) {
            case NONE -> "NONE";
            case CLOCKWISE_45 -> "CLOCKWISE_45";
            case CLOCKWISE -> "CLOCKWISE";
            case CLOCKWISE_135 -> "CLOCKWISE_135";
            case FLIPPED -> "FLIPPED";
            case FLIPPED_45 -> "FLIPPED_45";
            case COUNTER_CLOCKWISE -> "COUNTER_CLOCKWISE";
            case COUNTER_CLOCKWISE_45 -> "COUNTER_CLOCKWISE_45";
        };
    }

    public static Rotation stringToRotation(String string) {
        return switch (string) {
            case "NONE" -> Rotation.NONE;
            case "CLOCKWISE_45" -> Rotation.CLOCKWISE_45;
            case "CLOCKWISE" -> Rotation.CLOCKWISE;
            case "CLOCKWISE_135" -> Rotation.CLOCKWISE_135;
            case "FLIPPED" -> Rotation.FLIPPED;
            case "FLIPPED_45" -> Rotation.FLIPPED_45;
            case "COUNTER_CLOCKWISE" -> Rotation.COUNTER_CLOCKWISE;
            case "COUNTER_CLOCKWISE_45" -> Rotation.COUNTER_CLOCKWISE_45;
            default -> throw new IllegalStateException("Unexpected value: " + string);
        };
    }

    public static String blockFaceToString(BlockFace face) {
        return switch (face) {
            case NORTH -> "NORTH";
            case EAST -> "EAST";
            case SOUTH -> "SOUTH";
            case WEST -> "WEST";
            case UP -> "UP";
            case DOWN -> "DOWN";
            case NORTH_EAST -> "NORTH_EAST";
            case NORTH_WEST -> "NORTH_WEST";
            case SOUTH_EAST -> "SOUTH_EAST";
            case SOUTH_WEST -> "SOUTH_WEST";
            case WEST_NORTH_WEST -> "WEST_NORTH_WEST";
            case NORTH_NORTH_WEST -> "NORTH_NORTH_WEST";
            case NORTH_NORTH_EAST -> "NORTH_NORTH_EAST";
            case EAST_NORTH_EAST -> "EAST_NORTH_EAST";
            case EAST_SOUTH_EAST -> "EAST_SOUTH_EAST";
            case SOUTH_SOUTH_EAST -> "SOUTH_SOUTH_EAST";
            case SOUTH_SOUTH_WEST -> "SOUTH_SOUTH_WEST";
            case WEST_SOUTH_WEST -> "WEST_SOUTH_WEST";
            case SELF -> "SELF";
        };
    }

    public static BlockFace stringToBlockFace(String string) {
        return switch (string) {
            case "NORTH" -> BlockFace.NORTH;
            case "EAST" -> BlockFace.EAST;
            case "SOUTH" -> BlockFace.SOUTH;
            case "WEST" -> BlockFace.WEST;
            case "UP" -> BlockFace.UP;
            case "DOWN" -> BlockFace.DOWN;
            case "NORTH_EAST" -> BlockFace.NORTH_EAST;
            case "NORTH_WEST" -> BlockFace.NORTH_WEST;
            case "SOUTH_EAST" -> BlockFace.SOUTH_EAST;
            case "SOUTH_WEST" -> BlockFace.SOUTH_WEST;
            case "WEST_NORTH_WEST" -> BlockFace.WEST_NORTH_WEST;
            case "NORTH_NORTH_WEST" -> BlockFace.NORTH_NORTH_WEST;
            case "NORTH_NORTH_EAST" -> BlockFace.NORTH_NORTH_EAST;
            case "EAST_NORTH_EAST" -> BlockFace.EAST_NORTH_EAST;
            case "EAST_SOUTH_EAST" -> BlockFace.EAST_SOUTH_EAST;
            case "SOUTH_SOUTH_EAST" -> BlockFace.SOUTH_SOUTH_EAST;
            case "SOUTH_SOUTH_WEST" -> BlockFace.SOUTH_SOUTH_WEST;
            case "WEST_SOUTH_WEST" -> BlockFace.WEST_SOUTH_WEST;
            case "SELF" -> BlockFace.SELF;
            default -> throw new IllegalStateException("Unexpected value: " + string);
        };
    }

    public static EntityType getEntityByName(String name) {
        for (EntityType type : EntityType.values()) {
            if(type.name().equalsIgnoreCase(name)) {
                return type;
            }
        }
        return null;
    }

    public static Material getMaterialByName(String name) {
        for (Material mat : Material.values()) {
            if (mat.name().equalsIgnoreCase(name)) {
                return mat;
            }
        }
        return null;
    }

    public static void removeAllPassangers(Entity e) {
        for (Entity p : e.getPassengers()) {
            e.removePassenger(p);
        }
    }

}
