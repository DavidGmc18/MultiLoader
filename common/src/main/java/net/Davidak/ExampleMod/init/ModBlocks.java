package net.Davidak.ExampleMod.init;

import net.Davidak.ExampleMod.Constants;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;

public class ModBlocks {
    public static final Block EXAMPLE_BLOCK = register("example_block");

    private static Block register(String name) {
        return register(modBlockID(name), new Block(BlockBehaviour.Properties.of()));
    }

    private static Block register(String name, Block block) {
        return register(modBlockID(name), block);
    }

    private static Block register(ResourceKey<Block> resourceKey, Block block) {
        return Registry.register(BuiltInRegistries.BLOCK, resourceKey, block);
    }

    private static ResourceKey<Block> modBlockID(String name) {
        return ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, name));
    }

    public static void register() {}
}
