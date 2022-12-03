package io.github.cyklon73.cytils.bukkit;

import io.github.cyklon73.cytils.bukkit.recipe.RecipeType;
import io.github.cyklon73.cytils.utils.Util;
import io.github.cyklon73.cytils.bukkit.recipe.CraftingRecipe;
import io.github.cyklon73.cytils.bukkit.recipe.Recipe;
import io.github.cyklon73.cytils.bukkit.recipe.SmithingRecipe;
import io.github.cyklon73.cytils.utils.ListArray;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;

public class Manager implements Listener {

    private final ListArray<Recipe> recipes = new ListArray<>();
    private final ListArray<SmithingRecipe> smithingRecipes = new ListArray<>();

    private Plugin plugin;

    public void registerRecipe(Recipe recipe) {
        recipes.add(recipe);
    }

    public Recipe getRecipe(String id) {
        for (int i = 0; i < recipes.getSize(); i++) {
            if (recipes.get(i).id().equals(id)) return recipes.get(i);
        }
        return null;
    }


    public void setup(Plugin plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
        recipes.forEach((r) -> {
            if (r instanceof CraftingRecipe) registerCraftingRecipe((CraftingRecipe) r);
            if (r instanceof SmithingRecipe) registerSmithingRecipe((SmithingRecipe) r);
        });
    }

    private void registerCraftingRecipe(CraftingRecipe r) {
        int i = 0;
        for (String shape : Util.splitStringInLines(r.shape(), 3)) {
            if (StringUtils.isBlank(shape)) continue;
            Bukkit.getConsoleSender().sendMessage(shape);
            registerCraftingRecipe(new NamespacedKey(plugin, r.id() + ((i==0) ? "" : ("_" + i))), r.result(), shape, r.ingredient(new HashMap<>()), r.type());
            i++;
        }
    }

    private void registerCraftingRecipe(NamespacedKey nk, ItemStack result, String shape, HashMap<Character, RecipeChoice> ingredient, RecipeType type) {
        if (type.equals(RecipeType.SHAPE)) {
            ShapedRecipe sr = new ShapedRecipe(nk, result);
            String[] shapes = shape.split("\n");
            if (shapes.length == 0) return;
            if (shapes.length > 3) throw new IllegalArgumentException("Recipe with " + shapes.length + " shapes are not possible! Shape:\n" + shape);
            sr.shape(shapes);
            ingredient.forEach((k, v) -> {
                if (shape.contains(k + "")) sr.setIngredient(k, v);
            });
            Bukkit.addRecipe(sr);
        } else if (type.equals(RecipeType.SHAPELESS)) {
            ShapelessRecipe slr = new ShapelessRecipe(nk, result);
            ingredient.forEach((k, v) -> {
                slr.addIngredient(v);
            });
            Bukkit.addRecipe(slr);
        }
    }

    private void registerSmithingRecipe(SmithingRecipe r) {
        this.smithingRecipes.add(r);
    }

    private void discoverRecipes() {
        /*Bukkit.getOnlinePlayers().forEach((p) -> {
            recipes.forEach((r) -> p.discoverRecipe(new NamespacedKey(Survivalserver.getPlugin(), r.id())));
        });*/
    }

    /*@EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getClickedInventory() == null) return;
        if (!event.getClickedInventory().getType().equals(InventoryType.SMITHING)) return;
        SmithingInventory inv = (SmithingInventory) event.getClickedInventory();
        ItemStack baseItem = inv.getItem(0);
        ItemStack upgradeItem = inv.getItem(1);
        if (baseItem == null) return;
        if (upgradeItem == null) return;
        smithingRecipes.forEach((r) -> {
            if (baseItem.equals(r.baseItem())) {
                if (upgradeItem.equals(r.upgradeItem())) {
                    inv.setResult(r.result());
                }
            }
        });
        if (event.isShiftClick()) {
            if (inv.getResult() != null) {
                event.getWhoClicked().getInventory().addItem(inv.getResult());
            }

    }*/
}
