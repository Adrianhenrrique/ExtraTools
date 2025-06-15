package me.sfiguz7.extratools.lists;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.core.attributes.MachineTier;
import io.github.thebusybiscuit.slimefun4.core.attributes.MachineType;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.utils.LoreBuilder;
import me.sfiguz7.extratools.ExtraTools;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;

public final class ETItems {

    /* Category */
    public static final ItemGroup extra_tools = new ItemGroup(new NamespacedKey(ExtraTools.getInstance(),
            "extra_tools"),
            CustomItemStack.create(Material.DIAMOND_AXE, "&4Extra Tools")
    );
    /* Items */
    public static final SlimefunItemStack HAMMER = new SlimefunItemStack("HAMMER",
            Material.IRON_PICKAXE,
            "&cHammer",
            "",
            "&9Pulverizes blocks"
    );
    /* Machines */
    public static final SlimefunItemStack GOLD_TRANSMUTER = new SlimefunItemStack("GOLD_TRANSMUTER",
            Material.YELLOW_TERRACOTTA,
            "&6Gold Transmuter",
            "",
            LoreBuilder.machine(MachineTier.ADVANCED, MachineType.MACHINE),
            LoreBuilder.powerBuffer(256),
            LoreBuilder.powerPerSecond(18)
    );
    public static final SlimefunItemStack ELECTRIC_COMPOSTER = new SlimefunItemStack("ELECTRIC_COMPOSTER",
            Material.MAGENTA_TERRACOTTA,
            "&cElectric Composter",
            "",
            LoreBuilder.machine(MachineTier.ADVANCED, MachineType.MACHINE),
            "&8\u21E8 &7Speed: 1x",
            LoreBuilder.powerBuffer(256),
            LoreBuilder.powerPerSecond(18)
    );
    public static final SlimefunItemStack ELECTRIC_COMPOSTER_2 = new SlimefunItemStack("ELECTRIC_COMPOSTER_2",
            Material.MAGENTA_TERRACOTTA,
            "&cElectric Composter &7(&eII&7)",
            "",
            LoreBuilder.machine(MachineTier.ADVANCED, MachineType.MACHINE),
            "&8\u21E8 &7Speed: 4x",
            LoreBuilder.powerBuffer(256),
            LoreBuilder.powerPerSecond(50)
    );
    public static final SlimefunItemStack COBBLESTONE_GENERATOR = new SlimefunItemStack("COBBLESTONE_GENERATOR",
            Material.POLISHED_ANDESITE,
            "&cCobblestone Generator",
            "",
            LoreBuilder.machine(MachineTier.ADVANCED, MachineType.MACHINE),
            LoreBuilder.powerBuffer(256),
            LoreBuilder.powerPerSecond(36)
    );
    public static final SlimefunItemStack VAPORIZER = new SlimefunItemStack("VAPORIZER",
            Material.RED_STAINED_GLASS,
            "&cVaporizer",
            "",
            LoreBuilder.machine(MachineTier.ADVANCED, MachineType.MACHINE),
            LoreBuilder.powerBuffer(256),
            LoreBuilder.powerPerSecond(32)
    );
    public static final SlimefunItemStack CONCRETE_FACTORY = new SlimefunItemStack("CONCRETE_FACTORY",
            Material.BLACK_CONCRETE,
            "&4Concrete Factory",
            "",
            LoreBuilder.machine(MachineTier.ADVANCED, MachineType.MACHINE),
            LoreBuilder.powerBuffer(256),
            LoreBuilder.powerPerSecond(16)
    );
    public static final SlimefunItemStack PULVERIZER = new SlimefunItemStack("PULVERIZER",
            Material.ORANGE_TERRACOTTA,
            "&cPulverizer",
            "",
            LoreBuilder.machine(MachineTier.ADVANCED, MachineType.MACHINE),
            "&8\u21E8 &7Speed: 1x",
            LoreBuilder.powerBuffer(256),
            LoreBuilder.powerPerSecond(18)
    );

    // Dust Transmuter Machines
    public static final SlimefunItemStack BASIC_DUST_TRANSMUTER = new SlimefunItemStack("BASIC_DUST_TRANSMUTER",
            Material.IRON_BLOCK,
            "&7Basic Dust Transmuter",
            "",
            LoreBuilder.machine(MachineTier.BASIC, MachineType.MACHINE),
            "&8\u21E8 &7Transmutes dusts to ingots",
            LoreBuilder.powerBuffer(128),
            LoreBuilder.powerPerSecond(6)
    );
    public static final SlimefunItemStack ADVANCED_DUST_TRANSMUTER = new SlimefunItemStack("ADVANCED_DUST_TRANSMUTER",
            Material.DIAMOND_BLOCK,
            "&bAdvanced Dust Transmuter",
            "",
            LoreBuilder.machine(MachineTier.ADVANCED, MachineType.MACHINE),
            "&8\u21E8 &7Transmutes dusts faster & more efficiently",
            LoreBuilder.powerBuffer(256),
            LoreBuilder.powerPerSecond(12)
    );
    public static final SlimefunItemStack ULTIMATE_DUST_TRANSMUTER = new SlimefunItemStack("ULTIMATE_DUST_TRANSMUTER",
            Material.NETHERITE_BLOCK,
            "&dUltimate Dust Transmuter",
            "",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
            "&8\u21E8 &7Transmutes dusts at max efficiency",
            LoreBuilder.powerBuffer(512),
            LoreBuilder.powerPerSecond(24)
    );

    private ETItems() {
    }
}