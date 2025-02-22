package net.Davidak.ExampleMod;

import net.Davidak.ExampleMod.init.ModBlocks;
import net.Davidak.ExampleMod.init.ModCreativeTabs;
import net.Davidak.ExampleMod.init.ModItems;
import net.Davidak.ExampleMod.init.ModVanillaIntegration;
import net.fabricmc.api.ModInitializer;

public class ExampleMod implements ModInitializer {
    @Override
    public void onInitialize() {
        ModBlocks.register();
        ModItems.register();
        ModVanillaIntegration.register();
        ModCreativeTabs.register();

        CommonClass.init();
    }
}
