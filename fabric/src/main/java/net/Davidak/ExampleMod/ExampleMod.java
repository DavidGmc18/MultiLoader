package net.Davidak.ExampleMod;

import net.Davidak.ExampleMod.init.ModCreativeTabs;
import net.Davidak.ExampleMod.init.ModItems;
import net.fabricmc.api.ModInitializer;

public class ExampleMod implements ModInitializer {
    @Override
    public void onInitialize() {
        ModItems.register();
        ModCreativeTabs.register();

        CommonClass.init();
    }
}
