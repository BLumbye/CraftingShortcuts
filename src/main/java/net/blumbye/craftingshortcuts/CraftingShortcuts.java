package net.blumbye.craftingshortcuts;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class CraftingShortcuts extends JavaPlugin implements Listener {

    ArrayList<NamespacedKey> recipes;

    @Override
    public void onEnable() {
        recipes = new ArrayList<>();

        /// SLAB RECIPES
        recipes.add(MakeSlabRecipe(Material.OAK_SLAB, Material.OAK_PLANKS));
        recipes.add(MakeSlabRecipe(Material.SPRUCE_SLAB, Material.SPRUCE_PLANKS));
        recipes.add(MakeSlabRecipe(Material.BIRCH_SLAB, Material.BIRCH_PLANKS));
        recipes.add(MakeSlabRecipe(Material.JUNGLE_SLAB, Material.JUNGLE_PLANKS));
        recipes.add(MakeSlabRecipe(Material.ACACIA_SLAB, Material.ACACIA_PLANKS));
        recipes.add(MakeSlabRecipe(Material.DARK_OAK_SLAB, Material.DARK_OAK_PLANKS));
        recipes.add(MakeSlabRecipe(Material.STONE_SLAB, Material.STONE));
        recipes.add(MakeSlabRecipe(Material.SMOOTH_STONE_SLAB, Material.SMOOTH_STONE));
        recipes.add(MakeSlabRecipe(Material.SANDSTONE_SLAB, Material.SANDSTONE));
        recipes.add(MakeSlabRecipe(Material.COBBLESTONE_SLAB, Material.COBBLESTONE));
        recipes.add(MakeSlabRecipe(Material.BRICK_SLAB, Material.BRICK));
        recipes.add(MakeSlabRecipe(Material.NETHER_BRICK_SLAB, Material.NETHER_BRICK));
        recipes.add(MakeSlabRecipe(Material.QUARTZ_SLAB, Material.QUARTZ));
        recipes.add(MakeSlabRecipe(Material.CUT_SANDSTONE_SLAB, Material.CUT_SANDSTONE));
        recipes.add(MakeSlabRecipe(Material.RED_SANDSTONE_SLAB, Material.RED_SANDSTONE));
        recipes.add(MakeSlabRecipe(Material.CUT_RED_SANDSTONE_SLAB, Material.CUT_RED_SANDSTONE));
        recipes.add(MakeSlabRecipe(Material.PURPUR_SLAB, Material.PURPUR_BLOCK));
        recipes.add(MakeSlabRecipe(Material.PRISMARINE_SLAB, Material.PRISMARINE));
        recipes.add(MakeSlabRecipe(Material.PRISMARINE_BRICK_SLAB, Material.PRISMARINE_BRICKS));
        recipes.add(MakeSlabRecipe(Material.DARK_PRISMARINE_SLAB, Material.DARK_PRISMARINE));
        recipes.add(MakeSlabRecipe(Material.POLISHED_GRANITE_SLAB, Material.POLISHED_GRANITE));
        recipes.add(MakeSlabRecipe(Material.SMOOTH_RED_SANDSTONE_SLAB, Material.SMOOTH_RED_SANDSTONE));
        recipes.add(MakeSlabRecipe(Material.MOSSY_STONE_BRICK_SLAB, Material.MOSSY_STONE_BRICKS));
        recipes.add(MakeSlabRecipe(Material.POLISHED_DIORITE_SLAB, Material.POLISHED_DIORITE));
        recipes.add(MakeSlabRecipe(Material.MOSSY_COBBLESTONE_SLAB, Material.MOSSY_COBBLESTONE));
        recipes.add(MakeSlabRecipe(Material.END_STONE_BRICK_SLAB, Material.END_STONE_BRICKS));
        recipes.add(MakeSlabRecipe(Material.SMOOTH_SANDSTONE_SLAB, Material.SMOOTH_SANDSTONE));
        recipes.add(MakeSlabRecipe(Material.SMOOTH_QUARTZ_SLAB, Material.SMOOTH_QUARTZ));
        recipes.add(MakeSlabRecipe(Material.GRANITE_SLAB, Material.GRANITE));
        recipes.add(MakeSlabRecipe(Material.ANDESITE_SLAB, Material.ANDESITE));
        recipes.add(MakeSlabRecipe(Material.RED_NETHER_BRICK_SLAB, Material.RED_NETHER_BRICKS));
        recipes.add(MakeSlabRecipe(Material.DIORITE_SLAB, Material.DIORITE));

        /// LOG RECIPES
        // Chest
        RecipeChoice logs = new RecipeChoice.MaterialChoice(Tag.LOGS);
        ItemStack chestStack = new ItemStack(Material.CHEST,4);
        NamespacedKey chestKey = new NamespacedKey(this, "log_chest");
        ShapedRecipe chestRecipe = new ShapedRecipe(chestKey, chestStack);

        chestRecipe.shape("LLL","L L","LLL");
        chestRecipe.setIngredient('L', logs);

        Bukkit.addRecipe(chestRecipe);
        recipes.add(chestKey);

        // Sticks
        ItemStack stickStack = new ItemStack(Material.STICK,16);
        NamespacedKey stickKey = new NamespacedKey(this, "log_stick");
        ShapedRecipe stickRecipe = new ShapedRecipe(stickKey, stickStack);

        stickRecipe.shape("L","L");
        stickRecipe.setIngredient('L', logs);

        Bukkit.addRecipe(stickRecipe);
        recipes.add(stickKey);

        /// REPEATER RECIPE
        ItemStack repeaterStack = new ItemStack(Material.REPEATER);
        NamespacedKey repeaterKey = new NamespacedKey(this, "easy_repeater");
        ShapedRecipe repeaterRecipe = new ShapedRecipe(repeaterKey, repeaterStack);

        repeaterRecipe.shape("R R","SRS","###");
        repeaterRecipe.setIngredient('R', Material.REDSTONE);
        repeaterRecipe.setIngredient('S', Material.STICK);
        repeaterRecipe.setIngredient('#', Material.STONE);

        Bukkit.addRecipe(repeaterRecipe);
        recipes.add(repeaterKey);

        /// NAME TAG RECIPE
        ItemStack nameTagStack = new ItemStack(Material.NAME_TAG);
        NamespacedKey nameTagKey = new NamespacedKey(this, "name_tag");
        ShapelessRecipe nameTagRecipe = new ShapelessRecipe(nameTagKey, nameTagStack);

        nameTagRecipe.addIngredient(Material.LEAD);
        nameTagRecipe.addIngredient(Material.IRON_INGOT);

        Bukkit.addRecipe(nameTagRecipe);
        recipes.add(nameTagKey);


        Bukkit.getPluginManager().registerEvents(new EventListeners(recipes), this);
    }

    public NamespacedKey MakeSlabRecipe(Material slabMaterial, Material resultMaterial) {
        ItemStack resultStack = new ItemStack(resultMaterial);
        NamespacedKey namespacedKey = new NamespacedKey(this, "slab_" + resultMaterial.toString());
        ShapedRecipe recipe = new ShapedRecipe(namespacedKey, resultStack);

        recipe.shape("S","S");
        recipe.setIngredient('S', slabMaterial);

        Bukkit.addRecipe(recipe);
        return namespacedKey;
    }
}
