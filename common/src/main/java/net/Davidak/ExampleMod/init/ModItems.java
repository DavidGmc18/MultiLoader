package net.Davidak.ExampleMod.init;

import net.Davidak.ExampleMod.Constants;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.function.Function;

public class ModItems {
    public static final Item MOD_ICON = register("mod_icon");
    public static final Item EXAMPLE_ITEM = register("example_item", p -> new Item(p), new Item.Properties());

    private static Item register(String name) {
        return Items.registerItem(modItemID(name), Item::new, new Item.Properties());
    }

    private static Item register(String name, Function<Item.Properties, Item> factory) {
        return Items.registerItem(modItemID(name), factory, new Item.Properties());
    }

    private static Item register(String name, Item.Properties properties) {
        return Items.registerItem(modItemID(name), Item::new, properties);
    }

    private static Item register(String name, Function<Item.Properties, Item> factory, Item.Properties properties) {
        return Items.registerItem(modItemID(name), factory, properties);
    }

    private static ResourceKey<Item> modItemID(String name) {
        return ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, name));
    }

    public static void register() {}
}
