package io.github.cyklon73.cytils.bukkit;

import io.github.cyklon73.cytils.edsf.Data;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;

import java.io.*;
import java.util.ArrayList;

public class Build {
    public static void scan(File file, String name, Vector3 cord1, Vector3 cord2, World world, boolean copyAir, boolean copyEntities) throws RuntimeException {
        file = new File(file, name + ".edsf");

        if (!file.exists()) {
            try {
                PrintWriter writer = new PrintWriter(file, "UTF-8");
                int blockCount = 0;
                int entityCount = 0;

                Vector3 fV1 = new Vector3(Math.min(cord1.x, cord2.x), Math.min(cord1.y, cord2.y), Math.min(cord1.z, cord2.z));
                Vector3 fV2 = new Vector3(Math.max(cord1.x, cord2.x), Math.max(cord1.y, cord2.y), Math.max(cord1.z, cord2.z));

                writer.println(Util.EDSF.encode(fV1.toString()));
                writer.println(Util.EDSF.encode(fV2.toString()));

                //ArrayList<String> data = new ArrayList<>();
                for (double x = fV1.x; x <= fV2.x; x++) {
                    for (double y = fV1.y; y <= fV2.y; y++) {
                        for (double z = fV1.z; z <= fV2.z; z++) {
                            Vector3 v = new Vector3(x, y, z);
                            Block block = world.getBlockAt(v.toLocation(world));
                            BlockData blockData = block.getBlockData();
                            String s;
                            if (block.getState() instanceof Sign) {
                                Sign sign = (Sign) block.getState();
                                String s1 = sign.getLine(0) + Data.seperator + sign.getLine(1) + Data.seperator + sign.getLine(2) + Data.seperator + sign.getLine(3);
                                s = v.toBlockCordString() + Data.seperator + blockData.toString().substring(15, blockData.toString().length()-1) + Data.seperator + s1;
                            } else s = v.toBlockCordString() + Data.seperator + blockData.toString().substring(15, blockData.toString().length()-1);
                            if (copyAir) {
                                //data.add(s);
                                writer.println(Util.EDSF.encode(s));
                                blockCount++;
                            } else if (!block.getType().equals(Material.AIR)) {
                                //data.add(s);
                                writer.println(Util.EDSF.encode(s));
                                blockCount++;
                            }
                        }
                    }
                }
                if (copyEntities) {
                    for (Entity e : world.getEntities()) {
                        Vector3 entityPosition = Vector3.parseVector3(e.getLocation());
                        if(entityPosition.getX() >= fV1.getX()) {
                            if (entityPosition.getX() <= fV2.getX()) {
                                if (entityPosition.getY() >= fV1.getY()) {
                                    if (entityPosition.getY() <= fV2.getY()) {
                                        if(entityPosition.getZ() >= fV1.getX()) {
                                            if (entityPosition.getZ() <= fV2.getZ()) {
                                                if (e instanceof GlowItemFrame) {
                                                    ItemFrame frame = (GlowItemFrame) e;
                                                    String EntityString = "GlowItemFrame"
                                                            + Data.seperator
                                                            + Vector3.parseVector3(frame.getLocation()).toString()
                                                            + Data.seperator
                                                            + frame.getItem().getType().name()
                                                            + Data.seperator
                                                            + frame.isVisible()
                                                            + Data.seperator
                                                            + frame.isPersistent()
                                                            + Data.seperator
                                                            + Util.rotationToString(frame.getRotation())
                                                            + Data.seperator
                                                            + Util.blockFaceToString(frame.getFacing());
                                                    writer.println(Util.EDSF.encode(EntityString));
                                                }
                                                else if (e instanceof ItemFrame) {
                                                    ItemFrame frame = (ItemFrame) e;
                                                    String EntityString = "ItemFrame"
                                                            + Data.seperator
                                                            + Vector3.parseVector3(frame.getLocation()).toString()
                                                            + Data.seperator
                                                            + frame.getItem().getType().name()
                                                            + Data.seperator
                                                            + frame.isVisible()
                                                            + Data.seperator
                                                            + frame.isPersistent()
                                                            + Data.seperator
                                                            + Util.rotationToString(frame.getRotation())
                                                            + Data.seperator
                                                            + Util.blockFaceToString(frame.getFacing());
                                                    writer.println(Util.EDSF.encode(EntityString));
                                                } else if (!(e instanceof Player)) {
                                                    String EntityString = "Entity"
                                                            + Data.seperator
                                                            + Vector3.parseVector3(e.getLocation()).toString()
                                                            + Data.seperator
                                                            + e.getType().getName()
                                                            + Data.seperator
                                                            + e.getVelocity().toString()
                                                            + Data.seperator
                                                            + e.getCustomName();
                                                    writer.println(Util.EDSF.encode(EntityString));
                                                }
                                                entityCount++;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                //new EDSF(file).encodeWriter(data);
                writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            throw new RuntimeException("Dieser Build Name ist bereits vergeben!");
        }

    }

    public static void build(File file, String name, World world, boolean clearArea) {

        file = new File(file, name + ".edsf");

        int blockCount = 0;
        int entityCount = 0;

        int lineC = 0;
        Vector3 fV1 = null;
        Vector3 fV2;
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            for(String line; (line = br.readLine()) != null; ) {
                lineC++;
                if (lineC == 1) {
                    fV1 = Vector3.parseVector3(Util.EDSF.decode(line));
                }
                if (lineC == 2) {
                    fV2 = Vector3.parseVector3(Util.EDSF.decode(line));
                    if (clearArea) {
                        for (double x = fV1.x; x <= fV2.x; x++) {
                            for (double y = fV1.y; y <= fV2.y; y++) {
                                for (double z = fV1.z; z <= fV2.z; z++) {
                                    Vector3 v = new Vector3(x, y, z);
                                    Block block = world.getBlockAt(new Location(world, v.getBlockX(), v.getBlockY(), v.getBlockZ()));
                                    block.setType(Material.AIR);
                                }
                            }
                        }
                    }
                }
                if (lineC > 2) {
                    String s = Util.EDSF.decode(line);
                    String[] astring = s.split(Data.seperator);
                    if (astring[0].equals("GlowItemFrame")) {
                        GlowItemFrame frame = (GlowItemFrame) world.spawnEntity(Vector3.parseVector3(astring[1]).toLocation(world), EntityType.GLOW_ITEM_FRAME);
                        frame.setItem(new ItemStack(Util.getMaterialByName(astring[2])));
                        frame.setVisible(Boolean.parseBoolean(astring[3]));
                        frame.setPersistent(Boolean.parseBoolean(astring[4]));
                        frame.setRotation(Util.stringToRotation(astring[5]));
                        frame.setFacingDirection(Util.stringToBlockFace(astring[6]));
                        entityCount++;
                    }
                    else if (astring[0].equals("ItemFrame")) {
                        ItemFrame frame = (ItemFrame) world.spawnEntity(Vector3.parseVector3(astring[1]).toLocation(world), EntityType.ITEM_FRAME);
                        frame.setItem(new ItemStack(Util.getMaterialByName(astring[2])));
                        frame.setVisible(Boolean.parseBoolean(astring[3]));
                        frame.setPersistent(Boolean.parseBoolean(astring[4]));
                        frame.setRotation(Util.stringToRotation(astring[5]));
                        frame.setFacingDirection(Util.stringToBlockFace(astring[6]));
                        entityCount++;
                    }
                    else if (astring[0].equals("Entity")) {
                        Entity e = world.spawnEntity(Vector3.parseVector3(astring[1]).toLocation(world), Util.getEntityByName(astring[2]));
                        e.setVelocity(Vector3.parseVector3(astring[3]).toVector());
                        try {
                            if (!astring[4].equals("null")) e.setCustomName(astring[4]);
                        } catch (Exception ignored){}
                        entityCount++;
                    } else {
                        Vector3 v = Vector3.parseVector3(astring[0]);
                        Block block = world.getBlockAt(v.toLocation(world));
                        block.setBlockData(Bukkit.createBlockData(astring[1]));
                        if (astring.length == 6) {
                            Sign sign = (Sign) block.getState();
                            sign.setLine(0, astring[2]);
                            sign.setLine(1, astring[3]);
                            sign.setLine(2, astring[4]);
                            sign.setLine(3, astring[5]);
                            sign.update();
                        }
                        blockCount++;
                    }
                }
            }
            } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void delete(File buildData, String name) throws RuntimeException {
        if (name.equals("DELETE-ALL")) {
            File[] data = buildData.listFiles();

            for (File f:data) {
                f.delete();
            }
            return;
        }
        File file = new File(buildData, name + ".edsf");
        String[] s = file.toString().split("/");
        String fileName = s[s.length - 1].replace(".edsf", "");
        if (!file.delete()) {
            throw new RuntimeException("Datei konnte nicht gelöscht werden!");
        }
    }

    public static String listBuilds(File buildData) {
        ArrayList<String> list = new ArrayList<>();
        listAllBuilds(buildData, list);
        StringBuilder s = new StringBuilder();

        for (String s1 : list) {
            s.append(s1).append("\n");
        }

        return s.toString();
    }

    private static void listAllBuilds(File buildData, ArrayList<String> list) {
        File[] data = buildData.listFiles();
        assert data != null;
        for (File f:data) {
            if (f.getName().endsWith(".edsf")) {
                list.add(f.getName().replace(".edsf", ""));
            }
        }
    }

    public static String size(File buildData, String name) {
        File file = new File(buildData, name + ".edsf");
        String[] s = file.toString().split("/");
        String fileName = s[s.length - 1];
        long bytes = file.length();
        String[] size = Util.FILESIZE.decimalBased(bytes).split(" ");
        return size[0] + size[1] + " -> " + fileName;
    }

    public static void rename(File buildData, String nameBefore, String nameAfter) throws RuntimeException {
        File fileBefore = new File(buildData, nameBefore + ".edsf");
        File fileAfter = new File(buildData, nameAfter + ".edsf");

        if (!fileBefore.exists()) throw new RuntimeException(ChatColor.RED + "Der Build " + ChatColor.DARK_BLUE + nameBefore + ChatColor.RED + " konnte nicht gefunden werden!");

        if (fileAfter.exists()) throw new RuntimeException(ChatColor.RED + "Der Name " + ChatColor.DARK_BLUE + nameAfter + ChatColor.RED + " ist bereits vergeben!");

        if (!fileBefore.renameTo(fileAfter)) throw new RuntimeException(ChatColor.RED + " Der Build konnte nicht umbenannt werden!");
    }
}
