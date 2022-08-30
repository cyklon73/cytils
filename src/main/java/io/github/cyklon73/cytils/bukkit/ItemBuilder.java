package io.github.cyklon73.cytils.bukkit;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.List;

public class ItemBuilder {

    private ItemMeta meta;
    private ItemStack item;

    public ItemBuilder(Material material) {
        item = new ItemStack(material);
        meta = item.getItemMeta();
    }

    public ItemBuilder setDisplayName(String displayName) {
        meta.setDisplayName(displayName);
        return this;
    }

    public ItemBuilder setLocalizedName(String localizedName) {
        meta.setLocalizedName(localizedName);
        return this;
    }

    public ItemBuilder setUnbreakable(boolean breakable) {
        meta.setUnbreakable(breakable);
        return this;
    }

    public ItemBuilder addItemFlags(ItemFlag flag) {
        meta.addItemFlags(flag);
        return this;
    }

    public ItemBuilder setCustomModelData(Integer data) {
        meta.setCustomModelData(data);
        return this;
    }

    public ItemBuilder setLore(List<String> lore) {
        meta.setLore(lore);
        return this;
    }

    public ItemBuilder addEnchantment(Enchantment ench, Integer level) {
        meta.addEnchant(ench, level, true);
        return this;
    }

    public ItemBuilder setAmount(int amount) {
        item.setAmount(amount);
        return this;
    }

    public <T, Z> ItemBuilder setPersistentDataContainer(NamespacedKey key, PersistentDataType<T, Z> type, Z value) {
        meta.getPersistentDataContainer().set(key, type, value);
        return this;
    }

    @Override
    public String toString() {
        return "ItemBuilder{" +
                "ItemMeta=" + meta +
                ", ItemStack=" + item +
                "}";
    }

    public ItemStack build() {
        item.setItemMeta(meta);
        return item;
    }


}

