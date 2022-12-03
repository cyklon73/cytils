package io.github.cyklon73.cytils.bukkit.recipe;

import org.bukkit.inventory.RecipeChoice;

import java.util.HashMap;

public interface CraftingRecipe extends Recipe {
    RecipeType type();

    String shape();

    HashMap<Character, RecipeChoice> ingredient(HashMap<Character, RecipeChoice> map);
}
