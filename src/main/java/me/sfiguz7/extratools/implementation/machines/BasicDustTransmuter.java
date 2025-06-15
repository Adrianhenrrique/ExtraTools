package me.sfiguz7.extratools.implementation.machines;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.RecipeDisplayItem;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockBreakHandler;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AContainer;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.MachineRecipe;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.sfiguz7.extratools.lists.ETItems;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class BasicDustTransmuter extends AContainer implements RecipeDisplayItem {

    public BasicDustTransmuter() {
        super(ETItems.extra_tools, ETItems.BASIC_DUST_TRANSMUTER, RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] {null, SlimefunItems.IRON_DUST.item(), null,
                        SlimefunItems.ELECTRIC_MOTOR.item(), SlimefunItems.GOLD_24K_BLOCK.item(), SlimefunItems.ELECTRIC_MOTOR.item(),
                        new ItemStack(Material.IRON_PICKAXE), SlimefunItems.MEDIUM_CAPACITOR.item(),
                        new ItemStack(Material.IRON_PICKAXE)});

        addItemHandler(onBreak());
    }

    @Override
    protected void registerDefaultRecipes() {

        ItemStack goldDust = SlimefunItems.GOLD_DUST.item();
        goldDust.setAmount(16);

        ItemStack gold24K = SlimefunItems.GOLD_24K.item();

        registerRecipe(16, new ItemStack[] {goldDust},
                new ItemStack[] {gold24K});
//        // Gold dust: 16 -> 1
//        registerRecipe(12, new ItemStack[] {new ItemStack(SlimefunItems.GOLD_DUST, 16)},
//                new ItemStack[] {new ItemStack(Material.GOLD_INGOT)});
//        // Iron dust: 2 -> 1
//        registerRecipe(8, new ItemStack[] {new ItemStack(SlimefunItems.IRON_DUST, 2)},
//                new ItemStack[] {new ItemStack(Material.IRON_INGOT)});
//        // Copper dust: 2 -> 1
//        registerRecipe(8, new ItemStack[] {new ItemStack(SlimefunItems.COPPER_DUST, 2)},
//                new ItemStack[] {SlimefunItems.COPPER_INGOT.clone()});
//        // Silver dust: 2 -> 1
//        registerRecipe(8, new ItemStack[] {new ItemStack(SlimefunItems.SILVER_DUST, 2)},
//                new ItemStack[] {SlimefunItems.SILVER_INGOT.clone()});
//        // Adicione mais receitas conforme necessário
    }

    @Override
    public List<ItemStack> getDisplayRecipes() {
        List<ItemStack> displayRecipes = new ArrayList<>(recipes.size() * 2);

        for (MachineRecipe recipe : recipes) {
            displayRecipes.add(recipe.getInput()[0]);
            displayRecipes.add(recipe.getOutput()[0]);
        }

        return displayRecipes;
    }

    @Override
    public ItemStack getProgressBar() {
        return new ItemStack(Material.IRON_PICKAXE);
    }

    @Override
    public String getInventoryTitle() {
        return "&7Basic Dust Transmuter";
    }

    @Override
    public String getMachineIdentifier() {
        return "BASIC_DUST_TRANSMUTER";
    }

    @Override
    public int getCapacity() {
        return 128;
    }

    @Override
    public int getEnergyConsumption() {
        return 6;
    }

    @Override
    public int getSpeed() {
        return 1;
    }

    public BlockBreakHandler onBreak() {
        return new BlockBreakHandler(false, false) {
            @Override
            public void onPlayerBreak(BlockBreakEvent e, ItemStack item, List<ItemStack> drops) {
                Block b = e.getBlock();
                BlockMenu inv = BlockStorage.getInventory(b);

                if (inv != null) {
                    inv.dropItems(b.getLocation(), getInputSlots());
                    inv.dropItems(b.getLocation(), getOutputSlots());
                }
            }
        };
    }
}