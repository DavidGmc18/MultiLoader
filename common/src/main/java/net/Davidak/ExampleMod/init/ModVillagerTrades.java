package net.Davidak.ExampleMod.init;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerProfession;

import java.util.Arrays;

import static net.minecraft.world.entity.npc.VillagerTrades.*;

public class ModVillagerTrades {
    private static void entries() {
        addVillagerTrades(VillagerProfession.FARMER, 1, new ItemListing[]{
                new EmeraldForItems(ModItems.EXAMPLE_ITEM, 20, 16, 2),
                new EmeraldForItems(ModItems.EXAMPLE_BLOCK, 20, 16, 2)
        });

        addWanderingTrades(1, new ItemListing[]{
                new ItemsForEmeralds(ModItems.EXAMPLE_ITEM, 20, 16, 2),
                new ItemsForEmeralds(ModItems.EXAMPLE_BLOCK, 20, 16, 2)
        });
    }

    private static boolean registered = false;
    public static void register() {
        if (registered) return;
        entries();
        registered = true;
    }

    private static void addVillagerTrades(VillagerProfession profession, int level, ItemListing[] newTrades) {
        Int2ObjectMap<ItemListing[]> tradeMap = TRADES.get(profession);
        addTrades(tradeMap, level, newTrades);
    }

    private static void addWanderingTrades(int level, ItemListing[] newTrades) {
        addTrades(WANDERING_TRADER_TRADES, level, newTrades);
    }

    private static void addTrades(Int2ObjectMap<ItemListing[]> tradeMap, int level, ItemListing[] newTrades) {
        ItemListing[] oldTrades = tradeMap.get(level);
        ItemListing[] updatedTrades = Arrays.copyOf(oldTrades, oldTrades.length + newTrades.length);
        System.arraycopy(newTrades, 0, updatedTrades, oldTrades.length, newTrades.length);
        tradeMap.put(level, updatedTrades);
    }
}
