package me.sfiguz7.extratools.implementation.machines;

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

public class AdvancedDustTransmuter extends AContainer implements RecipeDisplayItem {

    public AdvancedDustTransmuter() {
        super(ETItems.extra_tools, ETItems.ADVANCED_DUST_TRANSMUTER, RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] {
                        null, ETItems.BASIC_DUST_TRANSMUTER.item(), null,
                        SlimefunItems.ELECTRIC_MOTOR.item(), SlimefunItems.GOLD_24K_BLOCK.item(), SlimefunItems.ELECTRIC_MOTOR.item(),
                        new ItemStack(Material.DIAMOND_PICKAXE), SlimefunItems.BIG_CAPACITOR.item(),
                        new ItemStack(Material.DIAMOND_PICKAXE)
                });
        addItemHandler(onBreak());
    }

    @Override
    protected void registerDefaultRecipes() {
        ItemStack goldDust = SlimefunItems.GOLD_DUST.item();
        goldDust.setAmount(8);

        ItemStack gold24K = SlimefunItems.GOLD_24K.item();

        registerRecipe(8, new ItemStack[] {goldDust},
                new ItemStack[] {gold24K});
    }

    @Override
    public List<ItemStack> getDisplayRecipes() {
        List<ItemStack> displayRecipes = new ArrayList<>(recipes.size() * 2);

        for (MachineRecipe recipe : recipes) {
            displayRecipes.add(recipe.getInput()[0]);
            displayRecipes.add(recipe.getOutput()[recipe.getOutput().length - 1]);
        }

        return displayRecipes;
    }

    @Override
    public ItemStack getProgressBar() {
        return new ItemStack(Material.DIAMOND_PICKAXE);
    }

    @Override
    public String getInventoryTitle() {
        return "&bAdvanced Dust Transmuter";
    }

    @Override
    public String getMachineIdentifier() {
        return "ADVANCED_DUST_TRANSMUTER";
    }

    @Override
    public int getCapacity() {
        return 256;
    }

    @Override
    public int getEnergyConsumption() {
        return 12;
    }

    @Override
    public int getSpeed() {
        return 2;
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