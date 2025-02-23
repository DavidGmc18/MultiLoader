package net.Davidak.ExampleMod.init;

import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import static net.minecraft.world.level.levelgen.GenerationStep.Decoration;

public class ModWorldGeneration {
    public static final BiomeModifierData EXAMPLE_TREE = new BiomeModifierData("example_tree",
            BiomeTags.IS_OVERWORLD, Decoration.VEGETAL_DECORATION, ModPlacedFeatures.EXAMPLE_TREE);

    public record BiomeModifierData(
            String name,
            TagKey<Biome> biomes,
            Decoration step,
            ResourceKey<PlacedFeature> feature
    ) {}
}
