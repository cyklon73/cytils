package io.github.cyklon73.cytils.bukkit.recipe;

import org.bukkit.inventory.ItemStack;

public interface SmithingRecipe extends Recipe {

    ItemStack baseItem();

    ItemStack upgradeItem();
}
