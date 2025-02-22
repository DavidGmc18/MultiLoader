package net.Davidak.ExampleMod;

import net.Davidak.ExampleMod.init.ModBlocks;
import net.Davidak.ExampleMod.init.ModCreativeTabs;
import net.Davidak.ExampleMod.init.ModItems;
import net.Davidak.ExampleMod.init.ModVanillaIntegration;
import net.minecraft.core.registries.Registries;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegisterEvent;

@Mod(Constants.MOD_ID)
@Mod.EventBusSubscriber(modid = Constants.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ExampleMod {
    public ExampleMod() {
        CommonClass.init();
    }

    @SubscribeEvent
    public static void registerEvent(RegisterEvent event) {
        if (event.getRegistryKey().equals(Registries.BLOCK)) ModBlocks.register();
        if (event.getRegistryKey().equals(Registries.ITEM)) {
            ModItems.register();
            ModVanillaIntegration.register();
        }
        if (event.getRegistryKey().equals(Registries.CREATIVE_MODE_TAB)) ModCreativeTabs.register();
    }
}