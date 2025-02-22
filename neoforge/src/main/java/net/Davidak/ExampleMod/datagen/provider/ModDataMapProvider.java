package net.Davidak.ExampleMod.datagen.provider;

import net.Davidak.ExampleMod.init.ModVanillaIntegration;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.Compostable;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;

import java.util.concurrent.CompletableFuture;

public class ModDataMapProvider extends DataMapProvider {
    Builder<Compostable, Item> compostables = this.builder(NeoForgeDataMaps.COMPOSTABLES);

    public ModDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather(HolderLookup.Provider lookup) {
        ModVanillaIntegration.compostables.forEach((item, chance) -> compostables.add(item.asItem().builtInRegistryHolder(), new Compostable(chance), false));
    }
}