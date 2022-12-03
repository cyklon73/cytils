package io.github.cyklon73.cytils.bukkit;

import org.bukkit.Material;
import org.bukkit.Rotation;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.util.Base64;

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

    public static class BASE64 {

        public static String decode(String input) {
            byte[] decoded = Base64.getDecoder().decode(input);
            return new String(decoded, StandardCharsets.UTF_8);
        }

        public static String encode(String input) {
            byte[] arg = input.getBytes(StandardCharsets.UTF_8);
            return Base64.getEncoder().encodeToString(arg);
        }
    }

    public static class EDSF {
        public static String encode(String input) {
            if (input == null) {
                return null;
            }
            String out = BASE64.encode(input);
            out = BASE64.encode(out);
            out = BASE64.encode(out);
            out = BASE64.encode(out);
            out = BASE64.encode(out);
            out = BASE64.encode(out);
            out = BASE64.encode(out);
            return out;
        }

        public static String decode(String input) {
            if (input == null) {
                return null;
            }
            String out = BASE64.decode(input);
            out = BASE64.decode(out);
            out = BASE64.decode(out);
            out = BASE64.decode(out);
            out = BASE64.decode(out);
            out = BASE64.decode(out);
            out = BASE64.decode(out);
            return out;
        }
    }

    public static class FILESIZE {
        public static final double
                KILO = 1000L,
                KIBI = 1024L,
                MEGA = KILO * KILO,
                MEBI = KIBI * KIBI,
                GIGA = MEGA * KILO,
                GIBI = MEBI * KIBI,
                TERA = GIGA * KILO,
                TEBI = GIBI * KIBI,
                PETA = TERA * KILO,
                PEBI = TEBI * KIBI,
                EXA = PETA * KILO,
                EXBI = PEBI * KIBI;

        private static final DecimalFormat df = new DecimalFormat("#.##");

        public static String binaryBased(long size) {
            if (size < 0) {
                throw new IllegalArgumentException("Argument cannot be negative");
            } else if (size < KIBI) {
                return df.format(size).concat("B");
            } else if (size < MEBI) {
                return df.format(size / KIBI).concat("KiB");
            } else if (size < GIBI) {
                return df.format(size / MEBI).concat("MiB");
            } else if (size < TEBI) {
                return df.format(size / GIBI).concat("GiB");
            } else if (size < PEBI) {
                return df.format(size / TEBI).concat("TiB");
            } else if (size < EXBI) {
                return df.format(size / PEBI).concat("PiB");
            } else {
                return df.format(size / EXBI).concat("EiB");
            }
        }

        public static String decimalBased(long size) {
            if (size < 0) {
                throw new IllegalArgumentException("Argument cannot be negative");
            } else if (size < KILO) {
                return df.format(size).concat(" B");
            } else if (size < MEGA) {
                return df.format(size / KILO).concat(" KB");
            } else if (size < GIGA) {
                return df.format(size / MEGA).concat(" MB");
            } else if (size < TERA) {
                return df.format(size / GIGA).concat(" GB");
            } else if (size < PETA) {
                return df.format(size / TERA).concat(" TB");
            } else if (size < EXA) {
                return df.format(size / PETA).concat(" PB");
            } else {
                return df.format(size / EXA).concat(" EB");
            }
        }
    }

}
