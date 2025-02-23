package net.Davidak.ExampleMod;

import net.Davidak.ExampleMod.init.*;
import net.fabricmc.api.ModInitializer;

public class ExampleMod implements ModInitializer {
    @Override
    public void onInitialize() {
        ModBlocks.register();
        ModItems.register();
        ModVanillaIntegration.register();
        ModCreativeTabs.register();
        ModVillagerTrades.register();

        CommonClass.init();
    }
}
