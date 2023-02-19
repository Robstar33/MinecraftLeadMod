package net.robstar.mymod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab NEW_MATERIALS = new CreativeModeTab("modtab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.LEAD.get());
        }
    };
}
