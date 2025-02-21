package net.Davidak.ExampleMod;

import net.Davidak.ExampleMod.init.ModBlocks;
import net.Davidak.ExampleMod.init.ModCreativeTabs;
import net.Davidak.ExampleMod.init.ModItems;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.RegisterEvent;

@Mod(Constants.MOD_ID)
@EventBusSubscriber(modid = Constants.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ExampleMod {
    public ExampleMod(IEventBus eventBus) {
        CommonClass.init();
    }

    @SubscribeEvent
    public static void registerEvent(RegisterEvent event) {
        if (event.getRegistryKey().equals(Registries.BLOCK)) ModBlocks.register();
        if (event.getRegistryKey().equals(Registries.ITEM)) ModItems.register();
        if (event.getRegistryKey().equals(Registries.CREATIVE_MODE_TAB)) ModCreativeTabs.register();
    }
}