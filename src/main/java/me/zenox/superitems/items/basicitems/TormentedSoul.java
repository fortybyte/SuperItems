package me.zenox.superitems.items.basicitems;

import me.zenox.superitems.SuperItems;
import me.zenox.superitems.items.ComplexItem;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.Recipe;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TormentedSoul extends ComplexItem implements Listener {

    public TormentedSoul() {
        super("Tormented Soul", "tormented_soul", Rarity.RARE, Type.MISC, Material.SPAWNER, Map.of());
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.GRAY + "A trapped soul, that has been tortured for generations.");
        this.getMeta().setLore(lore);
        this.getMeta().addEnchant(Enchantment.DAMAGE_ALL, 1, true);
        this.getMeta().addItemFlags(ItemFlag.HIDE_ENCHANTS);

        Bukkit.getPluginManager().registerEvents(this, SuperItems.getPlugin());
    }

    @Override
    public List<Recipe> getRecipes() {
        return List.of();
    }

    @EventHandler
    public void villagerDeathEvent(EntityDeathEvent e) {
        if (e.getEntity() instanceof Villager) {
            Villager v = (Villager) e.getEntity();
            if (v.getVillagerLevel() == 5) {
                v.getWorld().dropItemNaturally(v.getLocation(), this.getItemStack(1));
            }
        }
    }
}
