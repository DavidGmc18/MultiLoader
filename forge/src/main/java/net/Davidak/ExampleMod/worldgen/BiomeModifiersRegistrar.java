package net.Davidak.ExampleMod.worldgen;

import net.Davidak.ExampleMod.Constants;
import net.Davidak.ExampleMod.init.ModPlacedFeatures;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import static net.Davidak.ExampleMod.init.ModWorldGeneration.BiomeModifierData;

public class BiomeModifiersRegistrar {
    public static void bootstrap(BootstrapContext<BiomeModifier> context, Class<?> clazz) {
        HolderGetter<PlacedFeature> placedFeature = context.lookup(Registries.PLACED_FEATURE);
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);

        for (Field field : clazz.getFields()) {
            if (Modifier.isPublic(field.getModifiers()) && field.getType() == BiomeModifierData.class) {
                try {
                    BiomeModifierData data = (BiomeModifierData) field.get(null);
                    context.register(
                            ResourceKey.create(
                                    ForgeRegistries.Keys.BIOME_MODIFIERS,
                                    ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, data.name())),
                            new ForgeBiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(data.biomes()),
                                    HolderSet.direct(placedFeature.getOrThrow(ModPlacedFeatures.EXAMPLE_TREE)),
                                    data.step()));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
