package net.Davidak.ExampleMod.init;

import com.google.common.collect.Maps;
import net.Davidak.ExampleMod.platform.Services;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.HashMap;
import java.util.Map;

public class ModVanillaIntegration {
    private static void entries() {
        registerFlammable(ModBlocks.EXAMPLE_BLOCK, 20, 100);

        registerStrippable(Blocks.STRIPPED_OAK_LOG, Blocks.OAK_LOG);
        registerStrippable(Blocks.STRIPPED_SPRUCE_LOG, Blocks.SPRUCE_LOG);

        registerFlattenable(ModBlocks.EXAMPLE_BLOCK, Blocks.IRON_BLOCK.defaultBlockState());
        registerFlattenable(Blocks.AMETHYST_BLOCK, Blocks.GOLD_BLOCK.defaultBlockState());

        registerCompostable(0.3f, ModItems.EXAMPLE_ITEM);
    }

    // NeoForge uses DataMap for compostables (running datagen is required to apply changes)
    private static final boolean is_NeoForge = Services.PLATFORM.getPlatformName().equals("NeoForge");
    public static final Map<ItemLike, Float> compostables = new HashMap<>();

    public static void register() {
        AxeItem.STRIPPABLES = Maps.newHashMap(AxeItem.STRIPPABLES);
        entries();
    }

    private static void registerFlammable(Block block, int encouragement, int flammability) {
        ((FireBlock)Blocks.FIRE).setFlammable(block, encouragement, flammability);
    }

    private static void registerStrippable(Block log, Block stripped) {
        AxeItem.STRIPPABLES.put(log, stripped);
    }

    private static void registerFlattenable(Block block, BlockState flattened) {
        ShovelItem.FLATTENABLES.put(block, flattened);
    }

    private static void registerCompostable(float chance, ItemLike item) {
        if (is_NeoForge) compostables.put(item, chance);
        else ComposterBlock.COMPOSTABLES.put(item.asItem(), chance);
    }
}
