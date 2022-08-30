package io.github.cyklon73.cytils.bukkit;

import org.bukkit.Material;
import org.bukkit.Rotation;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

public class Util {

    public static String rotationToString(Rotation rotation) {
        switch (rotation) {
            case NONE:
                return "NONE";
            case CLOCKWISE_45:
                return "CLOCKWISE_45";
            case CLOCKWISE:
                return "CLOCKWISE";
            case CLOCKWISE_135:
                return "CLOCKWISE_135";
            case FLIPPED:
                return "FLIPPED";
            case FLIPPED_45:
                return "FLIPPED_45";
            case COUNTER_CLOCKWISE:
                return "COUNTER_CLOCKWISE";
            case COUNTER_CLOCKWISE_45:
                return "COUNTER_CLOCKWISE_45";
            default:
                throw new IllegalStateException("Unexpected value: " + rotation);
        }
    }

    public static Rotation stringToRotation(String string) {
        switch (string) {
            case "NONE":
                return Rotation.NONE;
            case "CLOCKWISE_45":
                return Rotation.CLOCKWISE_45;
            case "CLOCKWISE":
                return Rotation.CLOCKWISE;
            case "CLOCKWISE_135":
                return Rotation.CLOCKWISE_135;
            case "FLIPPED":
                return Rotation.FLIPPED;
            case "FLIPPED_45":
                return Rotation.FLIPPED_45;
            case "COUNTER_CLOCKWISE":
                return Rotation.COUNTER_CLOCKWISE;
            case "COUNTER_CLOCKWISE_45":
                return Rotation.COUNTER_CLOCKWISE_45;
            default:
                throw new IllegalStateException("Unexpected value: " + string);
        }
    }

    public static String blockFaceToString(BlockFace face) {
        switch (face) {
            case NORTH:
                return "NORTH";
            case EAST:
                return "EAST";
            case SOUTH:
                return "SOUTH";
            case WEST:
                return "WEST";
            case UP:
                return "UP";
            case DOWN:
                return "DOWN";
            case NORTH_EAST:
                return "NORTH_EAST";
            case NORTH_WEST:
                return "NORTH_WEST";
            case SOUTH_EAST:
                return "SOUTH_EAST";
            case SOUTH_WEST:
                return "SOUTH_WEST";
            case WEST_NORTH_WEST:
                return "WEST_NORTH_WEST";
            case NORTH_NORTH_WEST:
                return "NORTH_NORTH_WEST";
            case NORTH_NORTH_EAST:
                return "NORTH_NORTH_EAST";
            case EAST_NORTH_EAST:
                return "EAST_NORTH_EAST";
            case EAST_SOUTH_EAST:
                return "EAST_SOUTH_EAST";
            case SOUTH_SOUTH_EAST:
                return "SOUTH_SOUTH_EAST";
            case SOUTH_SOUTH_WEST:
                return "SOUTH_SOUTH_WEST";
            case WEST_SOUTH_WEST:
                return "WEST_SOUTH_WEST";
            case SELF:
                return "SELF";
        }
        return null;
    }

    public static BlockFace stringToBlockFace(String string) {
        switch (string) {
            case "NORTH":
                return BlockFace.NORTH;
            case "EAST":
                return BlockFace.EAST;
            case "SOUTH":
                return BlockFace.SOUTH;
            case "WEST":
                return BlockFace.WEST;
            case "UP":
                return BlockFace.UP;
            case "DOWN":
                return BlockFace.DOWN;
            case "NORTH_EAST":
                return BlockFace.NORTH_EAST;
            case "NORTH_WEST":
                return BlockFace.NORTH_WEST;
            case "SOUTH_EAST":
                return BlockFace.SOUTH_EAST;
            case "SOUTH_WEST":
                return BlockFace.SOUTH_WEST;
            case "WEST_NORTH_WEST":
                return BlockFace.WEST_NORTH_WEST;
            case "NORTH_NORTH_WEST":
                return BlockFace.NORTH_NORTH_WEST;
            case "NORTH_NORTH_EAST":
                return BlockFace.NORTH_NORTH_EAST;
            case "EAST_NORTH_EAST":
                return BlockFace.EAST_NORTH_EAST;
            case "EAST_SOUTH_EAST":
                return BlockFace.EAST_SOUTH_EAST;
            case "SOUTH_SOUTH_EAST":
                return BlockFace.SOUTH_SOUTH_EAST;
            case "SOUTH_SOUTH_WEST":
                return BlockFace.SOUTH_SOUTH_WEST;
            case "WEST_SOUTH_WEST":
                return BlockFace.WEST_SOUTH_WEST;
            case "SELF":
                return BlockFace.SELF;
            default:
                throw new IllegalStateException("Unexpected value: " + string);
        }
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
