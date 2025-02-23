package net.Davidak.ExampleMod.worldgen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import static net.Davidak.ExampleMod.init.ModWorldGeneration.BiomeModifierData;

public class BiomeModifiersRegistrar {
    public static void register(Class<?> clazz) {
        for (Field field : clazz.getFields()) {
            if (Modifier.isPublic(field.getModifiers()) && field.getType() == BiomeModifierData.class) {
                try {
                    BiomeModifierData data = (BiomeModifierData) field.get(null);
                    BiomeModifications.addFeature(BiomeSelectors.tag(data.biomes()), data.step(), data.feature());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
