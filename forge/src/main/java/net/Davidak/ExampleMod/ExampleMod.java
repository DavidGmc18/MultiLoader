package net.Davidak.ExampleMod;

import net.Davidak.ExampleMod.init.*;
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

        //TODO I am not sure if this is safe approach.
        if (event.getRegistryKey().equals(Registries.VILLAGER_PROFESSION)) ModVillagerTrades.register();
    }
}