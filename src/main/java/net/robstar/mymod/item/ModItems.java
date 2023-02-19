package net.robstar.mymod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.robstar.mymod.mymod;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, mymod.MOD_ID);

    public static final RegistryObject<Item> LEAD = ITEMS.register("lead",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.NEW_MATERIALS)));
    public static final RegistryObject<Item> RAW_LEAD = ITEMS.register("raw_lead",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.NEW_MATERIALS)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
